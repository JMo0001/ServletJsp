package kh.test.jdbckh.department.model.service;

import java.sql.Connection;
import java.util.List;

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

	public List<DepartmentVo> selectDepartmentList(){
		Connection conn =getConnection();
		List<DepartmentVo> result = dao.selectDepartmentList(conn);
		close(conn);
		return result;
	}
	
	public List<DepartmentVo> selectDepartmentList(String search) {
		Connection conn =getConnection();
		List<DepartmentVo> result = dao.selectDepartmentList(conn, search);
		close(conn);
		return result;
	}
	
	public List<DepartmentVo> selectDepartmentList(int currentPage, int pageSize){
		Connection conn = getConnection();
		List<DepartmentVo> result = dao.selectDepartmentList(conn, currentPage, pageSize);
		close(conn);
		return result;
	}
	
//	public int getTotalCount() {
//		Connection conn = getConnection();
//		int result = dao.getTotalCount(conn);
//		close(conn);
//		return result;
//	}
}
