package kh.test.jdbckh.departement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.departement.model.dto.DepartmentDto;
import kh.test.jdbckh.departement.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentGetServlet
 */
@WebServlet("/department/get")
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
		//전달받은 parameter 읽기.
		String departmentNo = request.getParameter("departmentNo");
		//전달받은 데이터로 DB 정보 가져오기.
		DepartmentService service = new DepartmentService();
		DepartmentDto dto = service.selectOne(departmentNo);
		if(dto == null) {
			//결과 없음.
			request.getRequestDispatcher("/WEB-INF/view/error/error.jsp").forward(request, response);
		}else {
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/WEB-INF/view/department/get.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
