package kh.test.jdbckh.board.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.board.model.dto.BoardDto;
import kh.test.jdbckh.board.model.service.BoardService;

/**
 * Servlet implementation class BoardReadServlet
 */
@WebServlet("/board/read")
public class BoardReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/*
	 * public BoardReadServlet() { super(); // TODO Auto-generated constructor stub
	 * }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void init(ServletConfig config) throws   ServletException{
		super.init(config);
		service = new BoardService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bnoStr = request.getParameter("bno");
		int bno = 0;
		if(bnoStr != null && !bnoStr.trim().equals("")) {
			try {
				bno = Integer.parseInt(bnoStr);
			}catch (Exception e) {
				request.getSession().setAttribute("successFailMsg", "존재하지 않는 게시글입니다. 목록에서 다시 선택해주세요.");
				response.sendRedirect(request.getContextPath()+"/board/list");
				return;
			}
		}
		BoardDto dto = service.selectOne(bno);
		request.setAttribute("bvo", dto);
		
		request.getRequestDispatcher("/WEB-INF/view/board/read.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
