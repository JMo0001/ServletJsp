package kh.test.jdbckh.board.model.service;

import java.sql.Connection;
import java.util.List;

import kh.test.jdbckh.board.model.dao.BoardDao;
import kh.test.jdbckh.board.model.dto.Board;

import static kh.test.jdbckh.common.JdbcTemplate.*;

public class BoardService {
	private BoardDao dao = new BoardDao();


	public List<Board> selectList(){
		List<Board> result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
}
