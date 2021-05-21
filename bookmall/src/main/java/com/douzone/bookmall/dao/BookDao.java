package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CategoryVo;

// bookmall 
public class BookDao {

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

	
	
	// insert
	public Boolean insert(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		
		
		try {
			conn = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			
			pstmt.setInt(1, vo.getPrice());
			pstmt.setString(2, vo.getTitle());
			pstmt.setInt(3, vo.getCategory_no());
			
			// 실행 
			int count = pstmt.executeUpdate();
			result = count == 1;
			
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	// 정보 출력하기 
	public List<BookVo> findAll() {
		List<BookVo> result =  new ArrayList<>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			conn = getConnection();
			
			
			String sql = "select b.no, b.price, b.title, c.gerne" 
						+ " from book b, category  c"
						+ " where b.category_no = c.no";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int no = rs.getInt(1);
				int price = rs.getInt(2);
				String title = rs.getString(3);
				String gerne = rs.getString(4);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setPrice(price);
				vo.setTitle(title);
				vo.setGenre(gerne);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	// delete
		public Boolean delete(int no) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
			
			
			try {
				conn = getConnection();
				
				String sql = "delete from book where no = ?";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				
				// 실행 
				int count = pstmt.executeUpdate();
				result = count == 1;
				
			} catch (SQLException e) {
				System.out.println("error: " + e);
			} finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
					
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
			
			return result;
		}
	
	
	// find, insert, delete 구현.
	
	
	
}
