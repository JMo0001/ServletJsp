package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentVo;
import kh.test.jdbckh.professor.model.service.ProfessorService;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;
import kh.test.jdbckh.student.model.service.StudentService;

/**
 * Servlet implementation class StudentInsertServlet
 */
@WebServlet("/student/insert")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService serviceDept = new DepartmentService();
	private ProfessorService servicePr = new ProfessorService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받은 parameter 읽어내기
		// 2. 전달받은 데이터를 활용해 DB 정보 가져오기
		//DB 다녀오기. >> 학과 번호, 지도교수번호 알아와야함.
		
		List<DepartmentVo> deptList = serviceDept.selectListForStudent();
		List<ProfessorVo> profList = servicePr.selectListProfessorForStudent();
		// 3. DB로부터 전달받은 데이터를 JSP에 전달함.
		
		if(deptList != null && deptList.size()>0) {
			request.setAttribute("deptList", deptList);
		}
		if(profList != null && profList.size()>0) {
			request.setAttribute("profList", profList);
		}
		// 4. JSP 파일 forward로 열기
		
		
		request.getRequestDispatcher("/WEB-INF/view/student/insert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
