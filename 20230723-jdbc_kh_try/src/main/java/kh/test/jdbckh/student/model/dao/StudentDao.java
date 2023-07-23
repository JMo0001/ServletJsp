package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {	//DB 연동, 기능 위주

	//PPT
	//메소드
	//DB에서 TB_STUDENT 테이블에 있는 모든 내용을 읽어서 꺼냄. >>void? >> return 타입은? > 
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. driver 있으면 로딩. 없으면 오류(classnotfound)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. Connection 객체 생성 	>> DB와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kh","kh");
			
			//3. statement or preparestatement 객체 생성.
			//conn 객체로부터 받아옴. >> sql문을 실어서 보냄.
			//select~~ 이면 resultset형 리턴.
			//update~~ 이면 int형 리턴.
//			stmt = conn.createStatement();
			String sql = "select * from tb_student";
			pstmt = conn.prepareStatement(sql);
			//쿼리문 실행해 달라고 함 .(sql = select ~~ >> resultset 리턴)
			ResultSet rs = pstmt.executeQuery();
			
			//5. resultset에서 row(record) 한줄 읽어오기 위해 curser(포인트)를 이동.
			result = new ArrayList<StudentVo>();
			while(rs.next()==true) {
				//한줄 읽을 준비 됨.
//				rs.getString("컬럼명");
				StudentVo vo = new StudentVo();
				vo.setStudentName(rs.getString("student_name"));
				vo.setStudentNo(rs.getString("student_no"));
				vo.setDepartmentNo(rs.getString("department_no"));
				vo.setStudentSsn(rs.getString("student_ssn"));
				vo.setEntranceDate(rs.getDate("entrance_date"));
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {	// driver가 없어.
			e.printStackTrace();
		} catch (SQLException e) {	//DB연결 실패
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
					}
				if(stmt!=null) {
					stmt.close();
					}
				if(conn!=null) {
					conn.close();
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
}
