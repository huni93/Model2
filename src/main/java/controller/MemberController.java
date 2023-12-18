package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Member;

public class MemberController extends MskimRequestMapping {
	
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
		return "/WEB-INF/view/member/index.jsp";
	}
	
	@RequestMapping("shopbasket")
	public String shopbasket(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/member/shopbasket.jsp";
	}
	
	@RequestMapping("memberlogout")
	public String memberlogout(HttpServletRequest request, HttpServletResponse res) throws Exception {
		HttpSession session=request.getSession();
		session.invalidate();
		request.setAttribute("msg", "logout 했습니다.");
		request.setAttribute("url", "/member/loginForm");
		
		return "/WEB-INF/view/alert.jsp";
	}
	
	@RequestMapping("memberinfo")
	public String memberinfo(HttpServletRequest request, HttpServletResponse res) throws Exception {
		MemberDao md = new MemberDao();
		HttpSession session=request.getSession();
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
		String tel = request.getParameter("tel");
		
		mem.setId(id);
		mem.setPassword(password);
		mem.setPassCheck(passcheck);
		mem.setName(name);		
		mem.setEmail(email);
		mem.setTel(tel);

		MemberDao md = new MemberDao();
		int num = md.insertMember(mem);
		
		String msg = "저장 하였습니다.";
		String url = "/member/loginForm";
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";
	}
}
