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
		//1. 전달받은 parameter 읽어내기 > 없다
		String searchWord = request.getParameter("searchWord");
		//2. 전달받은 데이터를 활용 > 없어.
		//2. DB 학생 상세 정보 가져오기.
		
		//dao에 있는 메소드를 호출.
		StudentDao dao = new StudentDao();
		List<StudentVo> result = null;
		if(searchWord != null) {
			System.out.println("[Mo] : "+searchWord);
			result = dao.selectListStudent(searchWord);
		} else {
			result = dao.selectListStudent();
		}
//		dao.selectListStudent();
		//3. DB로부터 전달받은 데이터를 JSP에 전달함.
		request.setAttribute("studentList", result);
		if(searchWord !=null) {
			request.setAttribute("searchWord", searchWord);
		}
		//4, JSP 파일 forward로 ㅕㅇㄹ기
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
