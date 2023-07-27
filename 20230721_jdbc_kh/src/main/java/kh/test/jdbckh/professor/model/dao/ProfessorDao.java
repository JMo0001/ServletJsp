package kh.test.jdbckh.professor.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
import kh.test.jdbckh.professor.model.vo.ProfessorVo;

public class ProfessorDao {
	
	
	
	//교수번호를 통한 교수 상세보기
	public ProfessorVo selectProfessorGet(Connection conn, String professorNo) {
		ProfessorVo result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_professor where professor_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, professorNo);
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
		}
//		System.out.println(result);
		return result;
	}
	
	//페이징 위해서 총 글 개수 알아냄.
	public int getTotalCount(Connection conn) {
		int result = 0;
		String totalQuery = "select count(*) cnt from tb_professor";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(totalQuery);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	//페이징 처리
	public List<ProfessorVo> selectProfessorList(Connection conn, int currentPage, int pageSize, int totalCnt) {
		
		List<ProfessorVo> result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from "
				+ " (select tb1.*, rownum rn from "
				+ " (select professor_no, professor_name, professor_ssn, professor_address, department_no "
				+ " from tb_professor order by professor_no asc) tb1) tb2 "
				+ " where rn between ? and ?";
		
		int startRownum =0;
		int endRownum = 0;
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		try {
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
		}
		return result;
	}
	
	public int getSearchTotalCount(Connection conn, String search) {
		int result = 0;
		String queryTotal = "select count(*) cnt from tb_professor "
				+ " where professor_name like ? ";
		search = "%"+search+"%";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(queryTotal);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<ProfessorVo> selectProfessorList(Connection conn, int currentPage, int pageSize, int totalCnt, String search){
		List<ProfessorVo> result = new ArrayList<ProfessorVo>();
		String query = "select * from "
				+ " (select tb1.*, rownum rn from "
				+ " (select professor_no, professor_name, professor_ssn, professor_address, department_no "
				+ " from tb_professor "
				+ " where professor_name like ?"
				+ " order by professor_no asc) tb1) tb2 "
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRownum = 0;
		int endRownum = 0;
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		
		search = "%"+search+"%";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, search);
			pstmt.setInt(2, startRownum);
			pstmt.setInt(3, endRownum);
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				ProfessorVo vo = new ProfessorVo();
				vo.setProfessorNo(rs.getString("professor_no"));
				vo.setProfessorName(rs.getString("professor_name"));
				vo.setProfessorSsn(rs.getString("professor_ssn"));
				vo.setProfessorAddress(rs.getString("professor_address"));
				vo.setDepartmentNo(rs.getString("department_no"));
				
				result.add(vo);
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
