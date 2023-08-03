package edu.kh.test.user.model.service;

import java.sql.Connection;

import edu.kh.test.user.JdbcTemplate;
import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

public class UserService {
	
	private UserDAO dao = new UserDAO();
	
	public UserDTO selectOne(int userNo) {
		UserDTO result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = dao.selectOne(conn, userNo);
		JdbcTemplate.close(conn);
		return result;
	}

}
