package kh.test.jdbckh.board.model.dao;


import kh.test.jdbckh.board.model.dto.BoardDto;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.getConnectionkhl;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;


import java.sql.Connection;
import java.util.List;

public class BoardService {
	
	private BoardDao dao = new BoardDao();
	
	public List<BoardDto> selectList(){
		List<BoardDto> result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	// 한 행 읽기 - PK로where조건
	public BoardDto selectOne(int bno){
		BoardDto result = null;
		Connection conn = getConnectionkhl();
		result = dao.selectOne(conn, bno);
		close(conn);
		return result;
	}
	// 한 행 삽입 - BoardDto 자료형을 받아와야 함.
	public int insert(BoardDto dto){
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	// 한 행 수정 - BoardDto 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
	public int update(BoardDto dto){
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.update(conn, dto);
		close(conn);
		return result;
	}
	// 한 행 삭제 - 주로 PK로 where조건
	public int delete(int bno){
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.delete(conn, bno);
		close(conn);
		return result;
	}
	
	//// 추가 
	// 페이징 처리 + 검색
	public int getTotalCount(String searchWord) {
		int result = 0;
		Connection conn = getConnectionkhl();
		result = dao.getTotalCount(conn, searchWord);
		close(conn);
		return result;
	}
	public List<BoardDto> selectList(int currentPage, int pageSize, String searchWord){
		List<BoardDto> result = null;
		Connection conn = getConnectionkhl();
		int totalCount = getTotalCount(searchWord);
		result = dao.selectList(conn, currentPage, pageSize, totalCount, searchWord);
		close(conn);
		return result;
	}
}
