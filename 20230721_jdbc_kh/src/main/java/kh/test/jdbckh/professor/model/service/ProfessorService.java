package kh.test.jdbckh.professor.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
import kh.test.jdbckh.professor.model.dao.ProfessorDao;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

public class ProfessorService {
	
	
	private ProfessorDao dao = new ProfessorDao();
	
	//1개 상세보기
	public ProfessorVo selectProfessorGet(String professorNo) {
		Connection conn = getConnection();
		ProfessorVo result = dao.selectProfessorGet(conn, professorNo);
		close(conn);
		return result;
	}
	
		
	//전체 글 개수 확인
	public int getTotalCount() {
		Connection conn = getConnection();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
	}
	
	//페이징 처리
	public Map<String, Object> selectProfessorList(int currentPage, int pageSize) {
		Connection conn = getConnection();
		int totalCnt = dao.getTotalCount(conn);
		List<ProfessorVo> result = dao.selectProfessorList(conn, currentPage, pageSize, totalCnt);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("professorList", result);
		close(conn);
		return map;
		
	}
	//검색 
	public Map<String, Object> selectProfessorList(int currentPage, int pageSize, String search){
		Connection conn = getConnection();
		int totalCnt = dao.getSearchTotalCount(conn, search);
		List<ProfessorVo> result = dao.selectProfessorList(conn, currentPage, pageSize, totalCnt, search);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("professorList", result);
		return map;
	}
	
}
