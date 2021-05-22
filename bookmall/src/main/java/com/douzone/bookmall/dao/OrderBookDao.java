package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CustomerVo;
import com.douzone.bookmall.vo.OrderBookVo;

public class OrderBookDao {
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			String id = "bookmall";
			String pw = "bookmall";
			
			
			conn = DriverManager.getConnection(url, id, pw);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 !!");
		}
		
		return conn;
	}

	// 중간 테이블
	// 서적  no, 수량, 가격, 총 가격 순으로 출력할 예정 
	// 서적  no, 가격 은 book 테이블에서, 
	public Boolean insert(OrderBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		
		try {
			conn = getConnection();
			String sql = "insert into orderbook values(?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBook_no());
			pstmt.setInt(2, vo.getAmount());
			pstmt.setInt(3, vo.getOrder_no());
			
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<OrderBookVo> findAll() {
		List<OrderBookVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 도서 번호, 제목, 가격, 수량, 주문번호 출력 
			String sql = "select b.no, b.title, b.price, ob.amount, o.orderno"
						+ " from book b, order_ o, orderbook ob"
						+ " where ob.book_no = b.no"
						+ " and ob.order_no = o.no";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int book_no = rs.getInt(1);
				String book_title = rs.getString(2);
				int book_price = rs.getInt(3);
				int amount = rs.getInt(4);
				int orderNo = rs.getInt(5);

				OrderBookVo vo = new OrderBookVo();

				vo.setBook_no(book_no);
				vo.setBook_title(book_title);
				vo.setBook_price(book_price);
				vo.setAmount(amount);
				vo.setOrderNo(orderNo);

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
	
	
	
	
	
	
	
}
