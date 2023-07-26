package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.service.StudentService;
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
		String pageNoStr = request.getParameter("pageNo");
		//String --> int
		int currentPage = 1;
		int pageSize = 10;
		if(pageNoStr != null) {
			try {
			currentPage = Integer.parseInt(pageNoStr);
			}catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		//2. 전달받은 데이터를 활용 > 없어.
		//2. DB 학생 상세 정보 가져오기.
		
		//dao에 있는 메소드를 호출.
		StudentService service = new StudentService();
//		List<StudentVo> result = null;
		Map<String, Object> map = null;
		if(searchWord != null) {
			//검색
//			result = service.selectListStudent(searchWord);
			map = service.selectListStudent(currentPage, pageSize, searchWord);
		} else {
			// 전체
//			result = dao.selectListStudent();
			// 페이징
			map = service.selectListStudent(currentPage, 10);
		}
//		dao.selectListStudent();
		//3. DB로부터 전달받은 데이터를 JSP에 전달함.
		request.setAttribute("studentList", map.get("studentList"));
		// 페이징 - 총 페이지
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0:1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		
		if(searchWord !=null) {
			request.setAttribute("searchWord", searchWord);
		}
		//4, JSP 파일 forward로 열기
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
