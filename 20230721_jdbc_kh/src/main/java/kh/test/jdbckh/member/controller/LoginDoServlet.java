package kh.test.jdbckh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.member.model.dto.Member;
import kh.test.jdbckh.member.model.service.MemberService;

/**
 * Servlet implementation class LoginDoServlet
 */
@WebServlet("/login.login")
public class LoginDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDoServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[JMO] login.login post");
		String mid = request.getParameter("mid");
		String mpwd = request.getParameter("mpwd");
		Member vo = new Member(mid, mpwd); 
		String result = new MemberService().login(mid);
		String sendUrl = request.getContextPath();
		if(mpwd.equals(result)) {
			System.out.println("로그인 성공");
			request.getSession().setAttribute("successMsg", "로그인성공" );
			request.getSession().setAttribute("SsLoginId", mid );
			sendUrl += "/board/list";
			System.out.println("LoginDoServlet : "+mid);
		}else {
			System.out.println("로그인 실패");
			request.getSession().setAttribute("failMsg", "로그인에 실패하였습니다.");
			sendUrl += "/board/list";
		}
		response.sendRedirect(sendUrl);
	}

}
