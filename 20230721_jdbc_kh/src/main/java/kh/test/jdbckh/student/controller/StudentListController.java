package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/student/list")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/student/list doGET() 진입");
		//TODO DB 연동
		//dao에 있는 메소드를 호출.
		StudentDao dao = new StudentDao();
//		dao.selectListStudent();
		List<StudentVo> result = dao.selectListStudent();
		
		request.setAttribute("studentList", result);
		request.setAttribute("aaa", "그냥 속성값 테스트 해봄");
		request.setAttribute("bbb", "그냥 속성값 테스트 해봄2");
		request.setAttribute("ccc", 333);
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
