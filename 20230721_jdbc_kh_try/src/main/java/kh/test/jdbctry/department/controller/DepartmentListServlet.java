package kh.test.jdbctry.department.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbctry.department.model.dao.DepartmentDao;
import kh.test.jdbctry.department.model.dto.DepartmentDto;
import kh.test.jdbctry.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentListController
 */
@WebServlet("/dept/list")
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepartmentDao dao = new DepartmentDao();
		DepartmentService service = new DepartmentService();
		List<DepartmentDto> dto = service.selectList();
		request.setAttribute("departmentList", dto);
		
		
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
