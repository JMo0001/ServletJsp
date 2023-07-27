package kh.test.jdbckh.department.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

/**
 * Servlet implementation class DepartmentListController
 */
@WebServlet("/department/list")
public class DepartmentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentVo> result = null;
		String search = request.getParameter("search");	//검색
		
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		int pageSize = 10;
		if(pageNoStr != null) {
			try {
				currentPage = Integer.parseInt(pageNoStr);	// NumberFormatException
			} catch( NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		DepartmentService service = new DepartmentService();
		Map<String, Object> map = null;
		
		if(search != null ) {
//			result = service.selectDepartmentList(search);
			map = service.selectDepartmentList(currentPage, pageSize, search);
		}else {
//			result = dao.selectDepartmentList();	//전체
//			result = service.selectDepartmentList(currentPage, 10);
			map = service.selectDepartmentList(currentPage, pageSize);
		}
		request.setAttribute("departmentList", map.get("departmentList"));
		
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
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
		
		
		if(search != null) {
			request.setAttribute("search", search);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/department/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
