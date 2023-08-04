package kh.test.jdbckh.student.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

import kh.test.jdbckh.department.model.vo.DepartmentVo;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;
import kh.test.jdbckh.student.model.dao.StudentDao;
import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentService {
	// transaction 트랜잭션 
	// Connection 관리
	// 일처리 단위별로 넣어줌. - for DAO
	// commit/rollback/연결해제
	private StudentDao dao = new StudentDao();
	
	public int insertstudent(StudentVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertStudent(conn, vo);
		close(conn);
		return result;
	}
	
	
	
	public StudentVo selectOneStudent(String studentNo) {
		Connection conn = getConnection();
		StudentVo result = dao.selectOneStudent(conn,studentNo);
		close(conn);
		return result;
	}
	public List<StudentVo> selectListStudent() { 
		Connection conn = getConnection();
		List<StudentVo> result = dao.selectListStudent(conn);
		close(conn);
		return result;
	}
	public List<StudentVo> selectListStudent(String searchWord) {  // 검색
		Connection conn = getConnection();
		List<StudentVo> result =  dao.selectListStudent(conn,searchWord);
		close(conn);
		return result;
	}
	
	//페이징 처리
	public Map<String, Object> selectListStudent(int currentPage, int pageSize ) {  
		Connection conn = getConnection();
		int totalCnt = dao.getTotalCount(conn);
		List<StudentVo> result =  dao.selectListStudent(conn,currentPage, pageSize, totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("studentList", result);
		return map;
	}
	
	//페이징 처리 + 검색
	public Map<String, Object> selectListStudent(int currentPage, int pageSize, String searchWord ) {  
		Connection conn = getConnection();
		int totalCnt = dao.getSearchTotalCount(conn, searchWord);
		List<StudentVo> result =  dao.selectListStudent(conn,currentPage, pageSize, totalCnt, searchWord);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("studentList", result);
		return map;
	}
	//전체 글 갯수 확인
	public int getTotalCount() {
		Connection conn = getConnection();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
	}
	
//	//추가 > professor로 이동
//		//학생 등록시 필요한 학과 정보 읽기
//		public List<ProfessorVo> selectListProfessorForStudent(){
//			List<DepartmentVo> result = null;
//			Connection conn =getConnection();
//			result = dao.selectListProfessorForStudent(conn);
//			close(conn);
//			return result;
//	}
}