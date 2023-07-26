package kh.test.jdbckh.tbclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.tbclass.model.dao.TbClassDao;
import kh.test.jdbckh.tbclass.model.vo.TbClassVo;

/**
 * Servlet implementation class TbClassListController
 */
@WebServlet("/class/list")
public class TbClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TbClassListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TbClassDao dao = new TbClassDao();
		List<TbClassVo> result = dao.selectListClass();
		String searchWord = request.getParameter("searchWord");
		
		if(searchWord != null) {
			result = dao.selectListClass(searchWord);
		}else {
			result = dao.selectListClass();
		}
		
		request.setAttribute("tbClassList", result);
		
		if(searchWord != null) {
			request.setAttribute("searchWord", searchWord);
		}
		
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
