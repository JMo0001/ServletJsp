package kh.test.jdbckh.ajax.controlloer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

/**
 * Servlet implementation class AjaxPageController
 */
@WebServlet("/ajaxtest")
public class AjaxPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DepartmentVo> deptList = new DepartmentService().selectListForStudent();
		Gson gson = new Gson();
		request.setAttribute("deptList", gson.toJson(deptList));
		
		request.getRequestDispatcher("/WEB-INF/view/ajaxtest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
