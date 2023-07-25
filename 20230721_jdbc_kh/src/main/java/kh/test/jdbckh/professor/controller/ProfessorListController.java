package kh.test.jdbckh.professor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.professor.model.dao.ProfessorDao;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

/**
 * Servlet implementation class ProfessorListController
 */
@WebServlet("/professor/list")
public class ProfessorListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfessorDao dao = new ProfessorDao();
		List<ProfessorVo> result = null;
		String searchWord = request.getParameter("searchWord");
		
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		if(pageNoStr != null) {
			try {
			currentPage = Integer.parseInt(pageNoStr);
			} catch ( NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		
		if(searchWord!=null) {
			result = dao.selectProfessorList(searchWord);
		}else {
//			result = dao.selectProfessorList();	//	전체선택
			result = dao.selectProfessorList(1, 10);
		}
		
		request.setAttribute("professorList", result);
		if(searchWord!=null) {
			request.setAttribute("searchWord", searchWord);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/professor/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
