package kh.test.jdbckh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.board.model.dto.Board;
import static kh.test.jdbckh.common.JdbcTemplate.*;

public class BoardDao {
	
	//전체보기
	public List<Board> selectList(Connection conn) {
		List<Board> result = new ArrayList<Board>();
		String query = "select bno, btitle, bcontent, "
				+ " to_char(bwrite_Date, 'yyyy/mm/dd hh24:mi:ss') bwrite_date, "
				+ " mid, bref, bre_Level, bre_Step from board "
				+ "	order by bref desc, bre_step asc";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next() == true) {
				Board dto = new Board(
						rs.getInt("bno"), 
						rs.getString("btitle"), 
						rs.getString("bwrite_date"),
						rs.getString("mid"), 
						rs.getInt("bref"), 
						rs.getInt("bre_level"), 
						rs.getInt("bre_Step")
						);
				result.add(dto);
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
