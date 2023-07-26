package kh.test.jdbckh.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

/**
 * Servlet implementation class DepartmentInsertDoServlet
 */
@WebServlet("/department/insert.do")
public class DepartmentInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentInsertDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//    private String departmentNo;
//	private String departmentName;
//	private String category;
//	private String openYn;
//	private int capacity;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String departmentNo=request.getParameter("departmentNo");
		String departmentName=request.getParameter("departmentName");
		String category=request.getParameter("category");
		String openYn=request.getParameter("openYn");
		String capacity=request.getParameter("capacity");
		
		DepartmentVo vo = new DepartmentVo();
		vo.setDepartmentNo(departmentNo);
		vo.setDepartmentName(departmentName);
		vo.setCategory(category);
		vo.setOpenYn(openYn);
		vo.setCapacity(capacity);
	
		DepartmentService service = new DepartmentService();
		int result = service.insertDepartment(vo);
		
		response.sendRedirect(request.getContextPath()+"/department/list");
	}

}
