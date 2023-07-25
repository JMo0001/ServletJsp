package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

public class DepartmentDao {
	
	
	public DepartmentVo selectOneDepartment(String departmentNo) {
		DepartmentVo result = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department where department_no = "+"'"+departmentNo+"'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = getConnection();
			
			
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentVo();
				result.setDepartmentNo(rs.getString("department_no"));
				result.setDepartmentName(rs.getString("department_name"));
				result.setCategory(rs.getString("category"));
				result.setOpenYn(rs.getString("open_yn"));
				result.setCapacity(rs.getInt("capacity"));
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		
		return result;
	}
	
	
	
	public List<DepartmentVo> selectDepartmentList() {	//listAll
		List<DepartmentVo> result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department";
		
		
			try {
				conn=getConnection();
				pstmt = conn.prepareStatement(query);
				rs=pstmt.executeQuery();
				
				result = new ArrayList<DepartmentVo>();
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getInt("capacity"));
					
					result.add(vo);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				close(conn);
			}
		
		
		
		
		
		return result;
	}
	//검색용
	public List<DepartmentVo> selectDepartmentList(String search) {
		List<DepartmentVo> result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from tb_department "
				+ "	where department_name like ? or category like ?";
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
				pstmt = conn.prepareStatement(query);
				search = "%"+search+"%";
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				
				rs=pstmt.executeQuery();
				
				result = new ArrayList<DepartmentVo>();
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getInt("capacity"));
					
					result.add(vo);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				close(conn);
			}
		return result;
	}

	
	public List<DepartmentVo> selectDepartmentList(int currentPage, int pageSize) {// Paging
		// int currentPage 현재 페이지 //	int pageSize 페이지당 글 개수
		List<DepartmentVo> result = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String queryTotalCnt = "select count(*) cnt from tb_department";
		String query = "select * from "
				+ " (select tb1.*, rownum rn "
				+ " from (select * from tb_department order by department_no asc) tb1 "
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		
		int totalCnt =0;
		int startRownum =0;
		int endRownum =0;
		
		
			try {
				conn=getConnection();
				
				pstmt=conn.prepareStatement(queryTotalCnt);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					totalCnt=rs.getInt("cnt");
				}
//				총페이지수 :  총글개수/한페이징당개수 + (총글개수%한페이징당개수 != 0 ? 1 : 0)
//				startRownum : (현재페이지-1)*한페이징당개수 + 1
//				endRownum  :  (현재페이지*한페이징당개수>총글개수 ? 총글개수 : 현재페이지*한페이징당개수)

				startRownum = (currentPage-1)*pageSize+1;
				endRownum = ((currentPage*pageSize)>totalCnt) ? totalCnt: (currentPage*pageSize);
				
				close(rs);
				close(pstmt);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRownum);
				pstmt.setInt(2, endRownum);
				rs=pstmt.executeQuery();
				
				result = new ArrayList<DepartmentVo>();
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getInt("capacity"));
					
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				close(conn);
			}
		return result;
	}
}
