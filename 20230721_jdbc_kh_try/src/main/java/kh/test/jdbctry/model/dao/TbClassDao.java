package kh.test.jdbctry.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbctry.model.vo.TbClassVo;

public class TbClassDao {
	
	public List<TbClassVo> selectListClass() {
		
		List<TbClassVo> result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			//1. driver 있다면 로딩. // 없다면 ClassNotFountException 오류 발생.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection 객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
			
			//3. Statement/PrepareStatement 객체 생성 
			String query = "select * from tb_class";
			pstmt = conn.prepareStatement(query);
			//4. query 문을 실행해달라고 하고 > 결과값을 return.
			ResultSet rt = pstmt.executeQuery();
			//5. ResultSet 에서 row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<TbClassVo>();
			while(rt.next()==true) {
				TbClassVo vo = new TbClassVo();
				vo.setClassNo(rt.getString("class_no"));
				vo.setDepartmentNo(rt.getString("department_no"));
				vo.setPreattendingClassNo(rt.getString("preattending_class_no"));
				vo.setClassName(rt.getString("class_name"));
				vo.setClassType(rt.getString("class_type"));
				result.add(vo);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
		
	}
	
}
