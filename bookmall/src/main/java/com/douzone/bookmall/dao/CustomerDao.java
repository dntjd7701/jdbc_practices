package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.douzone.bookmall.vo.CustomerVo;

public class CustomerDao {

	// connection
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			String id = "bookmall";
			String pw = "bookmall";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패, 드라이버 확인 요망");
		}

		return conn;

	}
	
	
	
	public Boolean insert(CustomerVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		
		try {
			conn = getConnection();
			
			
			String sql = "insert into customer values("
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		return result;
	}
	
	
	
	
	
	
	

}
