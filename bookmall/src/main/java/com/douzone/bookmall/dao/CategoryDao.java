package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.CategoryVo;

public class CategoryDao {

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
		public Boolean insert(CategoryVo vo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			boolean result = false;
			
			
			
			
			try {
				conn = getConnection();
				
				String sql = "insert into category values(null, ?)";
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, vo.getGenre());
				
				
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
		public List<CategoryVo> findAll() {
			List<CategoryVo> result =  new ArrayList<>();
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			
			try {
				conn = getConnection();
				
				
				String sql = "select *" 
							+ " from category";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					Long no = rs.getLong(1);
					String gerne = rs.getString(2);
					
					CategoryVo vo = new CategoryVo();
					vo.setNo(no);
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
			public Boolean delete(Long no) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				boolean result = false;
				
				
				try {
					conn = getConnection();
					
					String sql = "delete from category whre no = ?";
					pstmt = conn.prepareStatement(sql);
					
					
					pstmt.setLong(1, no);
					
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
