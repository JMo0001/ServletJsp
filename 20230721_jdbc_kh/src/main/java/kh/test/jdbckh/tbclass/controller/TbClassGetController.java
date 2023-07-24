package kh.test.jdbckh.tbclass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.tbclass.model.dao.TbClassDao;
import kh.test.jdbckh.tbclass.model.vo.TbClassVo;

/**
 * Servlet implementation class TbClassGetController
 */
@WebServlet("/class/get")
public class TbClassGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TbClassGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String classNo = request.getParameter("cno");
		TbClassDao dao = new TbClassDao();
		TbClassVo vo = dao.selectOneClass(classNo);
		request.setAttribute("oneVo", vo);
		
		request.getRequestDispatcher("/WEB-INF/view/class/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
