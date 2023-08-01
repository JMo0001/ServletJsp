package kh.test.jdbckh.departement.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.test.jdbckh.common.JdbcTemplate.*;

import kh.test.jdbckh.departement.model.dao.DepartmentDao;
import kh.test.jdbckh.departement.model.dto.DepartmentDto;

public class DepartmentService {

	private DepartmentDao dao = new DepartmentDao();
	
	//전체보기
	public List<DepartmentDto> selectList() {
		List<DepartmentDto> result = null;
		Connection conn = getConnectionkh();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	
	//한 행 읽기 - PK로 where 조건
	public DepartmentDto selectOne(String departmentNo) {
		DepartmentDto result = null;
		Connection conn = getConnectionkh();
		result = dao.selectOne(conn, departmentNo);
		close(conn);
		return result;
	}
}
