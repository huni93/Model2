package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import jumun.Jumun;
import kic.mskim.Login;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Member;

@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {
	
HttpSession session;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.session = request.getSession();
		super.service(request, resp);
	}
	
	@RequestMapping("MemberInput")
	public String MemberInput(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/member/MemberInput.jsp";
	}
	
	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/member/loginForm.jsp";
	}
	
	@RequestMapping("index")
	public String index(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		MemberDao md = new MemberDao();
		List<Jumun> li = md.jumunList();
		System.out.println(li);
		req.setAttribute("li", li);
		return "/WEB-INF/view/member/index.jsp";
	}
	
	@RequestMapping("memberlogout")
	public String memberlogout(HttpServletRequest request, HttpServletResponse res) throws Exception {
		session.invalidate();
		request.setAttribute("msg", "logout 했습니다.");
		request.setAttribute("url", "/member/loginForm");
		
		return "/WEB-INF/view/alert.jsp";
	}
	@Login(key = "id")
	@RequestMapping("memberinfo")
	public String memberinfo(HttpServletRequest request, HttpServletResponse res) throws Exception {
		MemberDao md = new MemberDao();
		String login = (String) session.getAttribute("id");
		Member mem = md.oneMember(login);
		request.setAttribute("mem", mem);
		return "/WEB-INF/view/member/memberinfo.jsp";
	}
	
	@RequestMapping("loginPro")
	public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDao md = new MemberDao();
		Member mem = md.oneMember(id);
		
		HttpSession session=request.getSession();

		String msg = "아이디를 확인하세요";
		String url = "/member/loginForm.jsp";
		if(mem != null) { //id 존재할때
			if (password.equals(mem.getPassword())) { //login ok
				session.setAttribute("id", id);
			msg = mem.getName() + "님이 로그인 하셨습니다.";
		    url = "/member/index";
			}else {
				msg = "비밀번호를 확인하세요";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";
	}

	@RequestMapping("memberPro")
	public String memberPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member mem = new Member();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passcheck = request.getParameter("passcheck");
		String name = request.getParameter("name") ;
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String tel = request.getParameter("tel");
		
		mem.setId(id);
		mem.setPassword(password);
		mem.setPassCheck(passcheck);
		mem.setName(name);		
		mem.setEmail(email);
		mem.setNickname(nickname);
		mem.setTel(tel);

		MemberDao md = new MemberDao();
		int num = md.insertMember(mem);
		
		String msg = "저장 하였습니다.";
		String url = "/member/loginForm";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";
	}
	
	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request, HttpServletResponse res) throws Exception {		
		String login =  (String) session.getAttribute("id");
		MemberDao md = new MemberDao();
		Member mem = md.oneMember(login);
		
		request.setAttribute("mem", mem);		
		
		return "/WEB-INF/view/member/memberUpdateForm.jsp";
	}
	
	@Login(key = "id")
	@RequestMapping("memberUpdatePro")
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
		String login =  (String) session.getAttribute("id");
		Member mem = new Member();  //client 에서 넘어온 자료
		request.setCharacterEncoding("utf-8");
		mem.setId(login); //session 저장 logout이면 에러남
		mem.setPassword(request.getParameter("password"));
		mem.setName(request.getParameter("name"));
		mem.setEmail(request.getParameter("email"));
		mem.setNickname(request.getParameter("nickname"));
		mem.setTel(request.getParameter("tel"));		
		

		MemberDao md = new MemberDao();
		Member memdb = md.oneMember(login);  //db에서 넘어온자료

		String msg = "수정 되지 않았습니다.";
		String url ="/member/memberUpdateForm";
		if(memdb!=null) {
			if(memdb.getPassword().equals(mem.getPassword())) {  //수정 ok
				  msg = "수정 되었습니다.";
				  md.updateMember(mem);
				  url ="/member/memberinfo";
			}else {
				msg="비밀번호가 틀렸습니다.";
			}
		}		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";
	}
	
	@RequestMapping("memberDeleteForm")
	public String memberDeleteForm(HttpServletRequest request, HttpServletResponse res) throws Exception {		
		
		return "/WEB-INF/view/member/memberDeleteForm.jsp";
	}
	
	@RequestMapping("memberDeletePro")
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse res) throws Exception {
		HttpSession session=request.getSession();
		String login =  (String) session.getAttribute("id");
	String password = request.getParameter("password");
	MemberDao md = new MemberDao();
	Member memdb = md.oneMember(login);
	String msg = "탈퇴되지 않았습니다.";
	String url ="/member/memberDeleteForm";

	if(memdb!=null) {
		if(memdb.getPassword().equals(password)) {  //비밀번호 확인
			  msg = "탈퇴 되었습니다.";
			  md.deleteMember(login);
			  session.invalidate();
			  url ="/member/index";
		}else {
			msg="비밀번호가 틀렸습니다.";
		}
	}
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	return "/WEB-INF/view/alert.jsp";
	}
	
	@RequestMapping("memberPassForm")
	public String memberPassForm(HttpServletRequest request, HttpServletResponse res) throws Exception {		
		
		return "/WEB-INF/view/member/memberPassForm.jsp";
	}
	
	@RequestMapping("memberPassPro")
	public String memberPassPro(HttpServletRequest request, HttpServletResponse res) throws Exception {
		HttpSession session=request.getSession();
		String login =  (String) session.getAttribute("id");
	String password = request.getParameter("password");
	String passcheck = request.getParameter("passcheck");

	MemberDao md = new MemberDao();
	Member memdb = md.oneMember(login);

	String msg = "비밀번호 수정을 실패 했습니다.";
	String url ="/member/memberPassForm";

	if(memdb!=null) {
		if(memdb.getPassword().equals(password)) {  
			  md.passMember(login, passcheck);
			  msg = login+"님이 비밀번호가 수정 되었습니다.";	  
			  url = "/member/index";
		}else {
			msg="비밀번호가 틀렸습니다.";
		}
	}
	request.setAttribute("msg", msg);
	request.setAttribute("url", url);
	
	return "/WEB-INF/view/alert.jsp";
	}

}
