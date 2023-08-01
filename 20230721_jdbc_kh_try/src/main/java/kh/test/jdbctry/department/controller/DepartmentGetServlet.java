package kh.test.jdbctry.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbctry.department.model.dto.DepartmentDto;
import kh.test.jdbctry.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentGetServlet
 */
@WebServlet("/dept/get")
public class DepartmentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentNo = request.getParameter("departmentNo");
		DepartmentService service = new DepartmentService();
		DepartmentDto dto = service.selectOne(departmentNo);
		if(dto != null) {
			request.setAttribute("getList", dto);
			request.getRequestDispatcher("/WEB-INF/view/department/get.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
