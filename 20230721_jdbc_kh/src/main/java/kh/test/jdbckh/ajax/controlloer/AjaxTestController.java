package kh.test.jdbckh.ajax.controlloer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTestController
 */
@WebServlet("/ajax1")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax doGET");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);
		// jsp로 데이터 전달
		// request.setAttribute 사용 불가
		// out는 원래 browser 화면 display 용도. >> ajax쓸 경우 데이터 전달용으로 사용함.
		// javascript가 인지할 수 있는 자료형으로 전달 해야함.
		
		PrintWriter out = response.getWriter();
//		out.print("ctrl -> jsp로 전달"); 
		out.print("저장되었습니다.-4");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax doPOST");
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		System.out.println("n1:"+n1);
		System.out.println("n2:"+n2);
	}

}
