package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
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
			conn = getConnection();
		
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
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
			conn = getConnection();
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
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		
		
		
		
		return result;
		
	}
	
	
	public List<ProfessorVo> selectProfessorList(String searchWord) {
		
		List<ProfessorVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_professor "
				+ " where professor_name like ? ";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			searchWord = "%"+searchWord+"%";
			pstmt.setString(1, searchWord);
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
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return result;
		
	}
	
	
	
public List<ProfessorVo> selectProfessorList(int currentPage, int pageSize) {
		
		List<ProfessorVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String totalQuery = "select count(*) cnt from tb_professor";
		
		String query = "select * from "
				+ " (select tb1.*, rownum rn from "
				+ " (select * from tb_professor order by professor_no asc) tb1) "
				+ " where rn between ? and ?";
		
		int totalCnt = 0;
		int startRownum =0;
		int endRownum = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(totalQuery);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCnt = rset.getInt("cnt");
			}
			
			startRownum = (currentPage-1)*pageSize+1;
			endRownum = ((currentPage*pageSize)>totalCnt) ? totalCnt: (currentPage*pageSize);
			
			close(rset);
			close(pstmt);
			
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			
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
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		return result;
		
	}
	
	
	
}
