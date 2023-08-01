package kh.test.jdbctry.department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbctry.common.JdbcTemplate.*;
import kh.test.jdbctry.department.model.dto.DepartmentDto;

public class DepartmentDao {
	
	
	public List<DepartmentDto> selectList(Connection conn){
		List<DepartmentDto> result = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select department_no, department_name, category, "
				+ " open_yn, capacity from tb_department";
		
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
				dto.setCapacity(rs.getString("capacity"));
				
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
	
	
	
	public DepartmentDto selectOne(Connection conn, String departmentNo) {
		DepartmentDto result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury = "select department_no, department_name, category, "
				+ " open_yn, capacity from tb_department "
				+ " where department_no =?";
		
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setString(1, departmentNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentDto(
						rs.getString("department_No"),
						rs.getString("department_name"),
						rs.getString("category"),
						rs.getString("open_yn"),
						rs.getString("capacity")
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
