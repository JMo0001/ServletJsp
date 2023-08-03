package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.JdbcTemplate;
import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	
	//pk 해당하는 값을 가져다가 where
	public UserDTO selectOne(Connection conn, int userNo) {
		UserDTO result = null;
		String qeury = "select user_no, user_id, user_name, user_age "
				+ "	from tb_user where user_no =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setInt(1, userNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new UserDTO(
						rs.getInt("user_No"),
						rs.getString("user_Id"),
						rs.getString("user_Name"),
						rs.getInt("user_Age")
						);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		return result;
	}
	
}
