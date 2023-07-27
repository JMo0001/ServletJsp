package kh.test.jdbckh.professor.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.professor.model.dao.ProfessorDao;
import kh.test.jdbckh.professor.model.service.ProfessorService;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

/**
 * Servlet implementation class ProfessorListController
 */
@WebServlet("/professor/list")
public class ProfessorListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfessorDao dao = new ProfessorDao();
		List<ProfessorVo> result = null;
		String search = request.getParameter("search");
		
		String pageNoStr = request.getParameter("pageNo");
		int currentPage = 1;
		int pageSize = 10;
		if(pageNoStr != null) {
			try {
			currentPage = Integer.parseInt(pageNoStr);
			} catch ( NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		ProfessorService service = new ProfessorService();
		Map<String, Object> map = null;
		if(search!=null) {
			map = service.selectProfessorList(currentPage, pageSize, search);
		}else {
//			result = dao.selectProfessorList();	//	전체선택
			map = service.selectProfessorList(currentPage, 10);
		}
		
		request.setAttribute("professorList", map.get("professorList"));
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0:1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage); 
		
		if(search!=null) {
			request.setAttribute("search", search);
		}
		
		request.getRequestDispatcher("/WEB-INF/view/professor/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
