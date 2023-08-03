package edu.kh.test.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.service.UserService;
import edu.kh.test.user.model.vo.UserDTO;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/selectuser")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private UserService service = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNoStr = request.getParameter("userNo");
		System.out.println(userNoStr);
		int userNo = 0;
		try {
		userNo = Integer.parseInt(userNoStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(userNo);
		
		UserDTO result = service.selectOne(userNo);
		if(result !=null) {
			request.setAttribute("udto", result);
			request.getRequestDispatcher("/WEB-INF/view/searchSuccess.jsp").forward(request, response);
		}else
			request.getRequestDispatcher("/WEB-INF/view/searchFail.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
