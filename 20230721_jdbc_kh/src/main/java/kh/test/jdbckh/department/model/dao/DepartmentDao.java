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
	
	//insert
	public int insertDepartment(Connection conn, DepartmentVo vo) {
		int result = 0;
		String query = "insert into tb_department (DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY) "
				+ " values (?,?,?,?,to_number(?))";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getDepartmentNo());
			pstmt.setString(2, vo.getDepartmentName());
			pstmt.setString(3, vo.getCategory());
			pstmt.setString(4, vo.getOpenYn());
			pstmt.setString(5, vo.getCapacity());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//한 행 읽기
	public DepartmentVo selectOneDepartment(Connection conn, String departmentNo) {	//oneSelect
		DepartmentVo result = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select "
				+ " DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY "
				+ " from tb_department where department_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, departmentNo );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentVo();
				result.setDepartmentNo(rs.getString("department_no"));
				result.setDepartmentName(rs.getString("department_name"));
				result.setCategory(rs.getString("category"));
				result.setOpenYn(rs.getString("open_yn"));
				result.setCapacity(rs.getString("capacity"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	

	//검색용
	public List<DepartmentVo> selectDepartmentList(Connection conn, String search) {
		List<DepartmentVo> result = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select "
				+ " DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY "
				+ " from tb_department "
				+ "	where department_name like ? or category like ?";
		
			try {
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
					vo.setCapacity(rs.getString("capacity"));
					
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		return result;
	}

	//총 글 개수
	public int getTotalCount(Connection conn) {
		int result = 0;	//	총 글 개수
		String query = "select count(*) cnt from tb_department";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("총 글 개수 : "+result);
		return result;
	}
	
	//페이징
	public List<DepartmentVo> selectDepartmentList(Connection conn, int currentPage, int pageSize, int totalCnt ) {
		// int currentPage 현재 페이지 //	int pageSize 페이지당 글 개수
		List<DepartmentVo> result = new ArrayList<DepartmentVo>();
//		String queryTotalCnt = "select count(*) cnt from tb_department";
		String query = "select * from "
				+ " (select tb1.*, rownum rn "
				+ " from (select "
				+ " DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY "
				+ " from tb_department order by department_no asc) tb1 "
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRownum =0;
		int endRownum =0;
		
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
			try {
//				pstmt=conn.prepareStatement(queryTotalCnt);
//				rs=pstmt.executeQuery();
//				if(rs.next()) {
//					totalCnt=rs.getInt("cnt");
//				}
////				총페이지수 :  총글개수/한페이징당개수 + (총글개수%한페이징당개수 != 0 ? 1 : 0)
////				startRownum : (현재페이지-1)*한페이징당개수 + 1
////				endRownum  :  (현재페이지*한페이징당개수>총글개수 ? 총글개수 : 현재페이지*한페이징당개수)
//
//				startRownum = (currentPage-1)*pageSize+1;
//				endRownum = ((currentPage*pageSize)>totalCnt) ? totalCnt: (currentPage*pageSize);
//				
//				close(rs);
//				close(pstmt);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startRownum);
				pstmt.setInt(2, endRownum);
				rs=pstmt.executeQuery();
				
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getString("capacity"));
					
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		return result;
	}

	//검색결과 + 페이징
	public int getSearchTotalCount(Connection conn, String search) {
		int result = 0;	//	총 글 개수
		String query = "select count(*) cnt from tb_department "
				+ " where department_name like ? or category like ? ";
		search = "%"+search+"%";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("총 글 개수 : "+result);
		return result;
	}
		
	//검색 + 페이징
	public List<DepartmentVo> selectDepartmentList(Connection conn, int currentPage, int pageSize, int totalCnt, String search ) {
		// int currentPage 현재 페이지 //	int pageSize 페이지당 글 개수
		List<DepartmentVo> result = new ArrayList<DepartmentVo>();
//		String queryTotalCnt = "select count(*) cnt from tb_department";
		String query = "select * from "
				+ " (select tb1.*, rownum rn "
				+ " from (select "
				+ " DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY "
				+ " from tb_department "
				+ " where department_name like ? or category like ? "
				+ " order by department_no asc) tb1 "
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int startRownum =0;
		int endRownum =0;
		
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
			try {
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				pstmt.setInt(3, startRownum);
				pstmt.setInt(4, endRownum);
				rs=pstmt.executeQuery();
				
				while (rs.next()==true) {
					DepartmentVo vo = new DepartmentVo();
					vo.setDepartmentNo(rs.getString("department_no"));
					vo.setDepartmentName(rs.getString("department_name"));
					vo.setCategory(rs.getString("category"));
					vo.setOpenYn(rs.getString("open_yn"));
					vo.setCapacity(rs.getString("capacity"));
					
					result.add(vo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
		return result;
	}
	
	//전체 리스트
//	public List<DepartmentVo> selectDepartmentList(Connection conn) {	//listAll
//		List<DepartmentVo> result = null;
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String query = "select "
//				+ " DEPARTMENT_NO, DEPARTMENT_NAME, CATEGORY, OPEN_YN, CAPACITY "
//				+ " from tb_department";
//			try {
//				pstmt = conn.prepareStatement(query);
//				rs=pstmt.executeQuery();
//				
//				result = new ArrayList<DepartmentVo>();
//				while (rs.next()==true) {
//					DepartmentVo vo = new DepartmentVo();
//					vo.setDepartmentNo(rs.getString("department_no"));
//					vo.setDepartmentName(rs.getString("department_name"));
//					vo.setCategory(rs.getString("category"));
//					vo.setOpenYn(rs.getString("open_yn"));
//					vo.setCapacity(rs.getString("capacity"));
//					
//					result.add(vo);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close(rs);
//				close(pstmt);
//			}
//		
//		return result;
//	}	
	
}