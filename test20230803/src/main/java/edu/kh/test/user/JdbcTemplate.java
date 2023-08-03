package edu.kh.test.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (conn != null){
			System.out.println("DB 연결 성공");
		}else {
			System.out.println("!!!!! DB 연결 실패 !!!!!");
		}
		
		return conn;
	}
	public static void close(Connection conn) {
		
		try {
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt!=null)stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset!=null)rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void setAutoCommit(Connection conn, boolean autocommit) {
		try {
			if(conn!=null)conn.setAutoCommit(autocommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void commit(Connection conn) {
		try {
			if(conn!=null)conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn!=null)conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
