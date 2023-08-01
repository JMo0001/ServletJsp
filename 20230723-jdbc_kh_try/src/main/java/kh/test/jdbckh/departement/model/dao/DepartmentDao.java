package kh.test.jdbckh.departement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbckh.common.JdbcTemplate.*;
import kh.test.jdbckh.departement.model.dto.DepartmentDto;

public class DepartmentDao {
	
	//전체 보기
	public List<DepartmentDto> selectList(Connection conn) {
		List<DepartmentDto> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select department_no, department_name, category, open_yn, "
				+ " capacity from tb_department order by department_no asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<DepartmentDto>();
			while(rs.next()) {
				DepartmentDto dto = new DepartmentDto();
				dto.setDepartmentNo(rs.getString("department_no"));
				dto.setDepartmentName(rs.getString("department_name"));
				dto.setCategory(rs.getString("category"));
				dto.setOpenYn(rs.getString("open_yn"));
				dto.setCapacity(rs.getInt("capacity"));
				
				result.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	//한 행 읽기 - PK로 where 조건
	public DepartmentDto selectOne(Connection conn, String departmentNo) {
		DepartmentDto result = null;
		String query = "select department_no, department_name, category, open_yn, capacity "
				+ " from tb_department where department_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, departmentNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentDto(
						rs.getString("department_no"),
						rs.getString("department_name"),
						rs.getString("category"),
						rs.getString("open_yn"),
						rs.getInt("capacity")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
}
