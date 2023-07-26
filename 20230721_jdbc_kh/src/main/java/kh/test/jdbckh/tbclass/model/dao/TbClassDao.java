package kh.test.jdbckh.tbclass.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
import kh.test.jdbckh.tbclass.model.vo.TbClassVo;

public class TbClassDao {
	
	
	public TbClassVo selectOneClass(String classNo) {
		System.out.println(classNo);
		TbClassVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qeury = "select c1.class_no, c1.department_no, c1.preattending_class_no, c1.class_name, "
				+ " c1.class_type , c2.class_name c2_class_name from tb_class c1 "
				+ " left join tb_class c2 on (c1.preattending_class_no = c2.class_no) "
				+ " where c1.class_no = ?";
		
		
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(qeury);
			pstmt.setString(1, classNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new TbClassVo();
				result.setClassNo(rs.getString("class_no"));
				result.setDepartmentNo(rs.getString("department_no"));
				result.setPreattendingClassNo(rs.getString("preattending_class_no"));
				result.setClassName(rs.getString("class_name"));
				result.setClasstype(rs.getString("class_type"));
				result.setClassname2(rs.getString("c2_class_name"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		
		System.out.println(result);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<TbClassVo> selectListClass() {	//	selectAll
		
		List<TbClassVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select class_no, class_name from tb_class";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<TbClassVo>();
			
			while(rs.next()==true) {
				TbClassVo vo = new TbClassVo();
				
				vo.setClassNo(rs.getString("class_no"));
				vo.setClassName(rs.getString("class_name"));
				
				result.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		
		return result;
		
	}

	
	
	public List<TbClassVo> selectListClass(String searchWord) {
		
		List<TbClassVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from tb_class "
				+ " where class_name like ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			
			searchWord = "%"+searchWord+"%";
			pstmt.setString(1, searchWord);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<TbClassVo>();
			
			while(rs.next()==true) {
				TbClassVo vo = new TbClassVo();
				
				vo.setClassNo(rs.getString("class_no"));
				vo.setClassName(rs.getString("class_name"));
				
				result.add(vo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		
		return result;
		
	}	
	
	
	
	
}
