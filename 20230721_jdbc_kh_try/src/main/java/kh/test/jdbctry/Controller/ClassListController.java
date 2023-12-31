package kh.test.jdbctry.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbctry.model.dao.TbClassDao;
import kh.test.jdbctry.model.vo.TbClassVo;

/**
 * Servlet implementation class ClassListController
 */
@WebServlet("/class/list")
public class ClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//dao에 있는 메소드를 호출.
		TbClassDao dao = new TbClassDao();
		List<TbClassVo> result = dao.selectListClass();
		
		request.setAttribute("classlist", result);
		request.getRequestDispatcher("/WEB-INF/view/class/list.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
