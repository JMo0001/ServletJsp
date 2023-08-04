package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.service.StudentService;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentInsertDoServlet
 */
@WebServlet("/student/insert.do")
public class StudentInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService service = new StudentService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertDoServlet() {
        super();
    }

//doGET 메소드 삭제
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐 방지 >> //TODO filter
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		 String studentNo =request.getParameter("studentNo") ;
		 String departmentNo = request.getParameter("departmentNo");
		 String studentName = request.getParameter("studentName");
		 String studentSsn = request.getParameter("studentSsn");
		 String studentAddress = request.getParameter("studentAddress");
//		 Date entranceDate = request.getParameter("entranceDate"); 오류
		 String entranceDate = request.getParameter("entranceDate");
		 String absenceYn = request.getParameter("absenceYn");
		 String coachProfessorNo = request.getParameter("coachProfessorNo");
		 
		 StudentVo vo = new StudentVo();
		 
		 vo.setStudentNo(studentNo);
		 vo.setDepartmentNo(departmentNo);
		 vo.setStudentName(studentName);
		 vo.setStudentSsn(studentSsn);
		 vo.setStudentAddress(studentAddress);
		 vo.setEntranceDate(entranceDate);
		 vo.setAbsenceYn(absenceYn);
		 vo.setCoachProfessorNo(coachProfessorNo);
		 System.out.println("[insert servlet] "+vo);
		 System.out.println("학과번호 >>>> "+departmentNo);
		 
		 int result = service.insertstudent(vo);
		 
		 if(result <1) {//등록 실패
			 request.getSession().setAttribute("masg", studentName+"등록 실패");
			 response.sendRedirect(request.getContextPath()+"/student/insert");
		 }else {//등록 성공
			 request.getSession().setAttribute("msg", studentName+"학색 등록 되었습니다.");
			 response.sendRedirect(request.getContextPath()+"/student/list");
		 }
		 
	}

}
