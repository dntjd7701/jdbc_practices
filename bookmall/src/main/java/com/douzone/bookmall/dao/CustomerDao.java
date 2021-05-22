package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			String sql = "insert into customer values(null, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNumber());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());

			// execute

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		}

		return result;
	}

	// select

	public List<CustomerVo> findAll() {
		List<CustomerVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 차후에 출력값 어떻게 나타낼지 결정하고 수정하
			String sql = "select *" + "from customer c";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String number = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);

				CustomerVo vo = new CustomerVo();

				vo.setNo(no);
				vo.setName(name);
				vo.setNumber(number);
				vo.setEmail(email);
				vo.setPassword(password);

				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return result;

	}
	
	// delete 
	
	public Boolean delete (int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		
		try {
			conn = getConnection();
			String sql = "delete from customer where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error : " + e);
			}
		}
		
		return result;
		
	}
	

}
