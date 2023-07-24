package kh.test.jdbckh.student.model.dao;	//DB 연동

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {
	//PPT 내용 구현
	//메소드2
	//tb_student 테이블의 전달받은 학번을 통해 학생 1명의 상세정보를 읽어오기.
	public StudentVo selectOneStudent(String studentNo) {
		System.out.println("DAO selectOndStudnet() arg:"+ studentNo);
		
		StudentVo result = null;
		String query = "select * from tb_student "
				+ "join tb_department using(department_no) "
//				+ "where student_no = "+"'"+studentNo+"'";	//stmt용.
				+ "where student_no = ?";	// ? : 위치 홀더
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
//			if(conn==null) {
//				System.out.println("연결 실패");
//			}else {
//				System.out.println("연결 성공");
//			}
			pstmt = conn.prepareStatement(query);
			//	pstmt 생성되고 execute 실행하기 전.
			//	여기서 ? 위치폴더에 값 넣기.
			pstmt.setString(1, studentNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {	//query 단일행이므로 while문 필요없음.
				result = new StudentVo();
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getDate("Entrance_date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("Student_name"));
				result.setStudentNo(rset.getString("Student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("department_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}
	
	
	
	//메소드1
	//DB에서 tb_student 테이블에 있는 모든 내용을 읽어서 꺼냄.
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		//try-catch 안에다 정의 하지 않는다.
		Connection conn = null;
		Statement stmt = null;		//statement와 preparedstatemend 둘 중 하나만 쓴다.
		PreparedStatement pstmt = null;
		
		try {	//oracledriver 클래스 있니 없니?
			//1. driver 있다면 로딩. // 없다면 ClassNotFountException 오류 발생.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			if(conn !=null) {	//확인용도. 필요 없다.
				System.out.println("DB 연결 성공!!!");
			}else {
				System.out.println("======DB 연결 실패======");
			}
			
			//3. Statement/PrepareStatement 객체 생성 >> conn 객체로부터 받아온다. conn. ~~
			//			query 문을 실어서 보낸다.
//			stmt = conn.createStatement();
			String sql = "select * from tb_student"; // String query 로도 이름 짓는다.
			pstmt =conn.prepareStatement(sql);
			
			//4. query 문을 실행해달라고 하고 > 결과값을 return.
			//select query 문이면 >>> ResultSet 모양 return.
			//insert/update/delete query 문이면 >>> int 모양 return.
			ResultSet rs = pstmt.executeQuery();
			
			//5. ResultSet 에서 row(record) 한 줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				// 한줄(row/record) 읽을 준비 완료.
//				System.out.println( rs.getString("STUDENT_NAME") );
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo(rs.getString("Department_No"));
				vo.setStudentName( rs.getString("Student_Name") );
				vo.setStudentSsn(rs.getString("Student_Ssn"));
				vo.setStudentAddress(rs.getString("Student_Address"));
				vo.setEntranceDate(rs.getDate("Entrance_Date"));
				vo.setAbsenceYn(rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo(rs.getString("Coach_Professor_No"));
				
				result.add(vo);
			} 
			
		} catch (ClassNotFoundException e) {
			//1. driver (ojdbc.jar) 없음.
			e.printStackTrace();
		} catch (SQLException e) {
			//2. dbms에 연결 실패.
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null){pstmt.close();}
				if(stmt!=null){stmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
//		System.out.println(result);
		
		return result;
	}
}
