package kh.test.jdbckh.department.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dao.DepartmentDao;
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
		DepartmentService service = new DepartmentService();
		String search = request.getParameter("search");	//검색
		
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		if(pageNoStr != null) {
			try {
				currentPage = Integer.parseInt(pageNoStr);	// NumberFormatException
			} catch( NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		
		if(search != null ) {
			result = service.selectDepartmentList(search);
		}else {
//			result = dao.selectDepartmentList();	//전체
			result = service.selectDepartmentList(currentPage, 10);
		}
		
		
		
		request.setAttribute("departmentList", result);
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
