package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.OrderVo;

public class OrderDao {

	// connection
	// getConnection 메소드 생성

	private Connection getConnection() throws SQLException {
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

	// insert, select, delete 순으로 생성

	public Boolean insert(OrderVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = getConnection();

			String sql = "insert into order_ values(null, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getOrderNo());
			pstmt.setString(2, vo.getAddress());
			pstmt.setInt(3, vo.getCustomer_no());
			

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error :" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error :" + e);
			}
		}

		return result;
	}

	
	// 값을 받아 vo에 저장하고 그 참조값을 List에 저장, 
	// 출력시에 순서대로 List를 꺼내서 출력.
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			String sql = "select o.no, o.orderno,c.name,"
					+ " o.address, ob.amount,"
					+ " (ob.amount * b.price) as total"
					+ " from order_ o, orderbook ob, customer c, book b"
					+ " where o.no = ob.order_no"
					+ " and c.no = o.customer_no"
					+ " and b.no = ob.book_no";
			
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt(1);
				int orderNo = rs.getInt(2);
				String customer_name = rs.getString(3);
				String address = rs.getString(4);
				int orderBook_amount = rs.getInt(5);
				int totalPrice = rs.getInt(6);
				

				OrderVo vo = new OrderVo();

				vo.setOrder_no(no);
				vo.setOrderNo(orderNo);
				vo.setCustomer_name(customer_name);
				vo.setAddress(address);
				vo.setOrderBook_amount(orderBook_amount);
				vo.setTotalPrice(totalPrice);

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
			String sql = "delete from order_ where no = ?";
			
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
