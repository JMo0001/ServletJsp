package kh.test.jdbckh.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.board.model.dto.BoardDto;
import kh.test.jdbckh.board.model.service.BoardService;

/**
 * Servlet implementation class BoadListServlet
 */
@WebServlet("/board/list")
public class BoadListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoadListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[JMo] 세션 attr");
		System.out.println(request.getSession().getAttribute("SsLoginId"));
		System.out.println(request.getAttribute("SsLoginId"));
		String msg = (String)request.getSession().getAttribute("successFailMsg");
		if(msg != null && !msg.equals("")) {
			request.setAttribute("successFailMsg", msg);
			request.getSession().removeAttribute("successFailMsg");
		}
		
		//1.request.getParameter()
		//2.service.selectList()
		List<BoardDto> result = new BoardService().selectList();
		//3
		request.setAttribute("boardList", result);
		//4.
		request.getRequestDispatcher("/WEB-INF/view/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
