package kh.test.jdbckh.ajax.controlloer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kh.test.jdbckh.department.model.service.DepartmentService;
import kh.test.jdbckh.department.model.vo.DepartmentVo;
import kh.test.jdbckh.professor.model.service.ProfessorService;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

/**
 * Servlet implementation class AjaxText2Controller
 */
@WebServlet("/ajax2")
public class AjaxText2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxText2Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("ajax2 doGET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax2 doPOST");
		List<DepartmentVo> deptList = new DepartmentService().selectListForStudent();
//		List<ProfessorVo> professorList = new ProfessorService().selectListProfessorForStudent();
		Gson gson = new Gson();
		int startPage = 2;
		int endPage = 4;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptList", deptList);
//		map.put("profList", professorList);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		String gsonDeptList = gson.toJson(deptList);
		System.out.println(gsonDeptList);
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(deptList));
		out.flush();
		out.close();
	}

}
