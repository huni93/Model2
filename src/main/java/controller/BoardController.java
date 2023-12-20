package controller;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dao.BoardDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.Board;

@WebServlet("/board/*")
public class BoardController extends MskimRequestMapping {

	@RequestMapping("index") //~~/board/index
	public String index(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/board/index.jsp";
	}
	

	@RequestMapping("boardForm") 
	public String boardForm(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/board/boardForm.jsp";
	}
	
	@RequestMapping("boardPro") 
	public String boardPro(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String path =
				req.getServletContext().getRealPath("/")+"image/board/";
		String filename = null;
		String msg = "게시물 등록 실패";
		String url = "/board/boardForm";
		
		MultipartRequest multi = new MultipartRequest
				(req,path,10*1024*1024,"utf-8");
		
		Board board = new Board();
		board.setBoardid("1");
		board.setName(multi.getParameter("name"));
		board.setPass(multi.getParameter("pass"));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setFile1(multi.getFilesystemName("file1"));  //name="file1"
		System.out.println(board);
		BoardDao bd = new BoardDao();
		int num = bd.insertBorad(board);
		if(num>0) {
			msg = "게시물 등록 성공";
			url = "/board/boardList";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		return "/WEB-INF/view/alert.jsp";
	}
	
	@RequestMapping("board") 
	public String board(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return "/WEB-INF/view/board/board.jsp";
	}
}
