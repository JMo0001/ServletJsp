package kh.test.jdbckh.professor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.professor.model.dao.ProfessorDao;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

/**
 * Servlet implementation class ProfessorGetController
 */
@WebServlet("/professor/get")
public class ProfessorGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String professorNo = request.getParameter("pno");
//		System.out.println(professorNo);
		ProfessorDao dao = new ProfessorDao();
		ProfessorVo vo = dao.selectProfessorGet(professorNo);
//		System.out.println(vo);
		request.setAttribute("oneVo", vo);
		
		
		request.getRequestDispatcher("/WEB-INF/view/professor/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
