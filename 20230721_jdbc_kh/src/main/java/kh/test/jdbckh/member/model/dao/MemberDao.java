package kh.test.jdbckh.member.model.dao;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.member.model.dto.Member;


public class MemberDao {

	
	// 모든 행 읽기
			public List<Member> selectList(Connection conn) {
				System.out.println("[Member Dao selectList]");
				List<Member> result = new ArrayList<Member>();
				
				//TODO

				String subquery = "select * from member"; // 정렬순서
				String query = subquery;

				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(query);
					rs = pstmt.executeQuery();

					while (rs.next() == true) {
						Member dto = new Member(
								rs.getString("mid"),
								rs.getString("manme"),
								rs.getString("memail")
								);
						result.add(dto);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(rs);
					close(pstmt);
				}
				System.out.println("[Member Dao selectList] return:" + result);
				return result;
			}
			
			// 한 행 읽기 - PK로where조건
			public Member selectOne(Connection conn, int bno) {
				System.out.println("[Member Dao selectOne] bno:" + bno);
				Member result = null;
				// TODO
				System.out.println("[Member Dao selectOne] return:" + result);
				return result;
			}

			// 한 행 삽입 - Member 자료형을 받아와야 함.
			public int insert(Connection conn, Member dto) {
				System.out.println("[Member Dao insert] dto:" + dto);
				int result = 0;
				String query = null;
				PreparedStatement pstmt = null;
				
				try {
					pstmt = conn.prepareStatement(query);
					
					
				result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
				
				System.out.println("[Member Dao insert] return:" + result);
				return result;
			}
			
			// 한 행 수정 - Member 또는 경우에 따라서 특정 컬럼값만 받아오기도 함.
			public int update(Connection conn, Member dto) {
				System.out.println("[Member Dao update] dto:" + dto);
				int result = -1;	//update경우 0도 정상 결과값일 수 있으므로 -1을 초기값으로 줌.
				String query = "update Member set BRE_STEP = BRE_STEP +1 where BRE_STEP > (SELECT BRE_STEP FROM Member WHERE BNO = ?) and BREF = (select bref from Member where bno = ?)";
				PreparedStatement pstmt = null;
				try {
					pstmt = conn.prepareStatement(query);
					result = pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
							
				System.out.println("[Member Dao update] return:" + result);
				return result;
			}

			// 한 행 삭제 - 주로 PK로 where조건
			public int delete(Connection conn, int bno) {
				System.out.println("Member Dao delete] bno:" + bno);
				int result = 0;
				// TODO
				System.out.println("[Member Dao delete] return:" + result);
				return result;
			}
			
			
			
			//추가
			//login : 성공 : 1, 실패 : 0 >> 암호화 적용 힘든 방식
			public int login(Connection conn, Member vo) {
				
				int result = 0;
				String query = "select count(*) cnt from member where mid =? and mpwd = ?";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, vo.getMid());
					pstmt.setString(2, vo.getMpwd());
					rs = pstmt.executeQuery();
					if(rs.next()){
						result = rs.getInt("cnt");
					}
								
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(pstmt);
				}
							
				System.out.println("[Member Dao update] return:" + result);
				return result;
			}
		
			
			//login : mpwd를 return 함. id 존재하지 않으면 return null
			public String login(Connection conn, String mid) {
				
				String result = null;
				String query = "select mpwd from member where mid=?";
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, mid);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						result = rs.getString(query);
						}
					} catch (SQLException e) {
					e.printStackTrace();
					} finally {
					close(pstmt);
					
				}
				System.out.println("[Member Dao update] return:" + result);
				return result;
			}
}
