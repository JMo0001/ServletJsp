package kh.test.jdbckh.ajax.controlloer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.test.jdbckh.member.model.dto.Member;

/**
 * Servlet implementation class AajaxTest4Controller
 */
@WebServlet("/ajax4")
public class AajaxTest4Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AajaxTest4Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajax4 doPOST");
	
		//요청받은 IO 중에서 BufferedReader 객체부분을 꺼내옴.
		BufferedReader br = request.getReader();
		String reqData = br.readLine();	//한줄만 읽으면 됨.
		System.out.println(reqData);
		
		Gson gson = new Gson();
		Member[] memberArray = gson.fromJson(reqData, Member[].class);
//		gson.fromJson(reqData, ArrayList<Member>.class);	ArrayList로 변형은 안됨.
		List<Member> memberList = Arrays.asList(memberArray);
		System.out.println(memberList);
		
	}

}
