package kh.test.jdbckh.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.board.model.dto.BoardDto;
import kh.test.jdbckh.board.model.service.BoardService;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert doGET()");
		//답글작성시 참조 글 번호
		String bnoStr = request.getParameter("bno");
		request.getAttribute(bnoStr);
		
		request.getRequestDispatcher("/WEB-INF/view/board/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board/insert doPOST()");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String mid = "khl";	//TODO 임시작성자 - 로그인한 id로 변경 예정
		
		//답글작성시 참조글번호
		String bnoStr = request.getParameter("bno");
		int bno = 0;
		if(bnoStr != null && bnoStr.equals("")) {
			try {
			bno = Integer.parseInt(bnoStr);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		//bno : 0이면 원본글, 그외 답글의 참조번호
		int result = service.insert(new BoardDto(bno, btitle, bcontent, mid));
		
		response.sendRedirect(request.getContextPath()+"/board/list");
	}
}
