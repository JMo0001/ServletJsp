package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.professor.model.vo.ProfessorVo;

public class ProfessorDao {
	
	public ProfessorVo selectProfessorGet(String professorNo) {
		ProfessorVo result = null;
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_professor where professor_no = "
				+ "'"+professorNo+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
		
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = new ProfessorVo();
				result.setProfessorNo(rs.getString("professor_no"));
				result.setProfessorName(rs.getString("professor_name"));
				result.setProfessorSsn(rs.getString("professor_ssn"));
				result.setProfessorAddress(rs.getString("professor_address"));
				result.setDepartmentNo(rs.getString("department_no"));
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
		
		
		
		
//		System.out.println(result);
		
		
		return result;
		
	}
	
	
	
	
	
	
	

	public List<ProfessorVo> selectProfessorList() {
		
		List<ProfessorVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_professor";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			result = new ArrayList<ProfessorVo>();
			
			while(rset.next() == true) {
				ProfessorVo vo = new ProfessorVo();
				vo.setProfessorNo(rset.getString("professor_no"));
				vo.setProfessorName(rset.getString("professor_name"));
				vo.setProfessorSsn(rset.getString("professor_ssn"));
				vo.setProfessorAddress(rset.getString("professor_address"));
				vo.setDepartmentNo(rset.getString("department_no"));
				
				result.add(vo);
			}
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return result;
		
	}
	
}
