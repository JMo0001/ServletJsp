package kh.test.jdbckh.department.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
import kh.test.jdbckh.department.model.dao.DepartmentDao;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	public int insertDepartment(DepartmentVo vo) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insertDepartment(conn, vo);
		close(conn);
		return result;
	}
	
	public DepartmentVo selectOneDepartment(String departmentNo) {
		Connection conn = getConnection();
		DepartmentVo result = dao.selectOneDepartment(conn, departmentNo);
		close(conn);
		return result;
	}

//	public List<DepartmentVo> selectDepartmentList(){
//		Connection conn =getConnection();
//		List<DepartmentVo> result = dao.selectDepartmentList(conn);
//		close(conn);
//		return result;
//	}
	
	public List<DepartmentVo> selectDepartmentList(String search) {
		Connection conn =getConnection();
		List<DepartmentVo> result = dao.selectDepartmentList(conn, search);
		close(conn);
		return result;
	}
	
	public Map<String, Object> selectDepartmentList(int currentPage, int pageSize){
		Connection conn = getConnection();
		int totalCnt = dao.getTotalCount(conn);
		List<DepartmentVo> result = dao.selectDepartmentList(conn,currentPage,pageSize,totalCnt);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("departmentList", result);
		return map;
	}
	
	public Map<String, Object> selectDepartmentList(int currentPage, int pageSize, String search){
		Connection conn = getConnection();
		int totalCnt = dao.getSearchTotalCount(conn,search);
		List<DepartmentVo> result = dao.selectDepartmentList(conn, currentPage, pageSize, totalCnt, search);
		close(conn);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", totalCnt);
		map.put("departmentList", result);
		return map;
	}
	
	public int getTotalCount() {
		Connection conn = getConnection();
		int result = dao.getTotalCount(conn);
		close(conn);
		return result;
	}
	
	//추가 
	//학생 등록시 필요한 학과 정보 읽기
	public List<DepartmentVo> selectListForStudent(){
		List<DepartmentVo> result = null;
		Connection conn =getConnection();
		result = dao.selectListForStudent(conn);
		close(conn);
		return result;
}
	
	
	
}
