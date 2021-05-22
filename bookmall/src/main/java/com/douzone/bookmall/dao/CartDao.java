package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CartVo;

public class CartDao {
	public Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			String id = "bookmall";
			String pw = "bookmall";

			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Boolean insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getAmount());
			pstmt.setInt(2, vo.getBook_no());
			pstmt.setInt(3, vo.getCustomer_no());

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error : " + e);
			}
		}
		return result;
	}

	public Boolean delete(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "delete from cart where book_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error : " + e);
			}
		}

		return result;
	}

	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select ct.name, b.title, c.amount" + " from cart c, customer ct, book b"
					+ " where c.customer_no = ct.no" + " and c.book_no = b.no";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String customer_name = rs.getString(1);
				String book_title = rs.getString(2);
				int amount = rs.getInt(3);

				CartVo vo = new CartVo();

				vo.setCustomer_name(customer_name);
				vo.setBook_title(book_title);
				vo.setAmount(amount);

				result.add(vo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e) {
				System.out.println("error :" + e);
			}
		}

		return result;
	}

}
