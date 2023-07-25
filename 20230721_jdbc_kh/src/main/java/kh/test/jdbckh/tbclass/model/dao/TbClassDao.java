package kh.test.jdbckh.tbclass.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
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
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(result);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<TbClassVo> selectListClass() {
		
		List<TbClassVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select class_no, class_name from tb_class";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh", "kh");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<TbClassVo>();
			
			while(rs.next()==true) {
				TbClassVo vo = new TbClassVo();
				
				vo.setClassNo(rs.getString("class_no"));
				vo.setClassName(rs.getString("class_name"));
				
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
