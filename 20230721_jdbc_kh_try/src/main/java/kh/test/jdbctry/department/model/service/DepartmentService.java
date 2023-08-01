package kh.test.jdbctry.department.model.service;

import static kh.test.jdbctry.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbctry.department.model.dao.DepartmentDao;
import kh.test.jdbctry.department.model.dto.DepartmentDto;

public class DepartmentService {
	
	private DepartmentDao dao = new DepartmentDao();
	
	public List<DepartmentDto> selectList(){
		List<DepartmentDto> result = null;
		Connection conn = getConnectionkh();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	
	public DepartmentDto selectOne(String departmentNo) {
		DepartmentDto result = null;
		Connection conn = getConnectionkh();
		result = dao.selectOne(conn, departmentNo);
		close(conn);
		return result;
	}
	

}
