package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import dao.CartDao;
import dao.MemberDao;
import jumun.Cart;
import jumun.Jumun;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.MyBoard;

@WebServlet("/jumun/*")
public class JumunController extends MskimRequestMapping {
	BoardDao bd = new BoardDao();
	
	
	
	@RequestMapping("jumunAdd")
	public String jumunadd(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        CartDao cd = new CartDao();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
		cd.addToCart(req.getParameter("jno"), id);
		
		req.setAttribute("msg", "추가 되었습니다");
		req.setAttribute("url", "/jumun/jumunList");
		return "/WEB-INF/view/alert.jsp";
		
	}
	
	@RequestMapping("jumunList")
	public String jumunList(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        CartDao cd = new CartDao();
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
		List<Cart>  li = cd.jumunList(id);

		System.out.println(li);
		req.setAttribute("li", li);
		
		return "/WEB-INF/view/jumun/jumunList.jsp";
	}
	
}


