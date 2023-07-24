package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentDao {
	
	
	public DepartmentVo selectOneDepartment(String departmentNo) {
		DepartmentVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department where department_no = "+"'"+departmentNo+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
			
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentVo();
				result.setDepartmentNo(rs.getString("department_no"));
				result.setDepartmentName(rs.getString("department_name"));
				result.setCategory(rs.getString("category"));
				result.setOpenYn(rs.getString("open_yn"));
				result.setCapacity(rs.getInt("capacity"));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<DepartmentVo> selectDepartmentList() {
		List<DepartmentVo> result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department";
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
				pstmt = conn.prepareStatement(query);
				rs=pstmt.executeQuery();
				
				result = new ArrayList<DepartmentVo>();
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getInt("capacity"));
					
					result.add(vo);
				}
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		
		
		
		return result;
	}

}
