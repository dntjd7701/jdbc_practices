package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.dao.CartDao;
import com.douzone.bookmall.dao.CategoryDao;
import com.douzone.bookmall.dao.CustomerDao;
import com.douzone.bookmall.dao.OrderBookDao;
import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.BookVo;
import com.douzone.bookmall.vo.CartVo;
import com.douzone.bookmall.vo.CategoryVo;
import com.douzone.bookmall.vo.CustomerVo;
import com.douzone.bookmall.vo.OrderBookVo;
import com.douzone.bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {

		// 순서
		// 카테고리, 서적, 고객, 주문, 주문도서, 카트

		// 카테고리
		division("Category");
		insertCategory("소설");
		insertCategory("사회");
		insertCategory("자기계발");
		System.out.println("======================");
		List<CategoryVo> categoryList = new CategoryDao().findAll();
		showInfo(categoryList);

		// 서적
		division("Book");
		insertBook(13320, "하품의 언덕", 1);
		insertBook(16200, "백신 거부자들", 2);
		insertBook(15120, "사는게 정답이 있으려나 ?", 3);
		System.out.println("======================");
		List<BookVo> bookList = new BookDao().findAll();
		showInfo(bookList);

		// 고객
		division("Customer");
		insertCustomer("우성", "010 5252 1455", "ccc@gmail.com", "125hjlkhj");
		insertCustomer("은영", "010 3523 4263", "aaa@gmail.com", "asdf791j");
		System.out.println("======================");
		List<CustomerVo> customerList = new CustomerDao().findAll();
		showInfo(customerList);

		// 주문 // 입력
		division("Order");
		insertOrder(24543, "해운대", customerList.get(0));
		insertOrder(12345, "세종", customerList.get(1));
		System.out.println("======================");
		// 주문 출력
//		List<OrderVo> orderList = new OrderDao().findAll();
//		showInfo(orderList);
		// 주문도서 
		division("OrderBook");
		insertOrderBook(1, 3, 1);
		insertOrderBook(2, 1, 2);
//		insertOrderBook(bookList.get(1), 3, orderList.get(1));
//		insertOrderBook(bookList.get(1), 2, orderList.get(1));
		System.out.println("======================");
		List<OrderBookVo> orderBookList = new OrderBookDao().findAll();
		showInfo(orderBookList);
		
		
		System.out.println("======================");
		System.out.println("주문 리스트입니다.");
		List<OrderVo> orderList = new OrderDao().findAll();
		showInfo(orderList);
		
		
		//카트 
		division("Cart");
		insertCart(2, 1, 1);
		insertCart(1, 3, 2);
		System.out.println("======================");
		List<CartVo> cartList = new CartDao().findAll();
		showInfo(cartList);
		
	}
	
	
	
	
	

	private static void insertCart(int amount, int book_no, int customer_no) {
		CartVo vo = null;

		vo = new CartVo();
		vo.setBook_no(book_no);
		vo.setAmount(amount);
		vo.setCustomer_no(customer_no);

		boolean result = new CartDao().insert(vo);
		System.out.println(result ? "Cart 항목 입력 성공 ! " : "입력 실패 ㅠ");

		
	}





	private static void insertOrderBook(int i, int amount, int j) {
		OrderBookVo vo = null;

		vo = new OrderBookVo();
		vo.setBook_no(i);
		vo.setAmount(amount);
		vo.setOrder_no(j);

		boolean result = new OrderBookDao().insert(vo);
		System.out.println(result ? "OrderBook 항목 입력 성공 ! " : "입력 실패 ㅠ");
	}
//	private static void insertOrderBook(BookVo bookVo, int amount, OrderVo orderVo) {
//		OrderBookVo vo = null;
//
//		vo = new OrderBookVo();
//		vo.setBook_no(bookVo.getNo());
//		vo.setAmount(amount);
//		vo.setOrder_no(orderVo.getOrder_no());
//		new OrderBookDao().insert(vo);
//
//		boolean result = new OrderBookDao().insert(vo);
//		System.out.println(result ? "OrderBook 항목 입력 성공 ! " : "입력 실패 ㅠ");
//	}

	private static void insertOrder(int orderNo, String address, CustomerVo customerVo) {
		OrderVo vo = null;

		vo = new OrderVo();
		vo.setOrderNo(orderNo);
		vo.setAddress(address);
		vo.setCustomer_no(customerVo.getNo());

		boolean result = new OrderDao().insert(vo);
		System.out.println(result ? "Order 항목 입력 성공 ! " : "입력 실패 ㅠ");

	}

	private static void insertCustomer(String name, String number, String email, String password) {
		CustomerVo vo = null;

		vo = new CustomerVo();
		vo.setName(name);
		vo.setNumber(number);
		vo.setEmail(email);
		vo.setPassword(password);
		boolean result = new CustomerDao().insert(vo);
		System.out.println(result ? "Customer 항목 입력 성공 ! " : "입력 실패 ㅠ");

	}

	private static void insertBook(int price, String title, int category_no) {
		BookVo vo = null;

		vo = new BookVo();
		vo.setPrice(price);
		vo.setTitle(title);
		vo.setCategory_no(category_no);

		boolean result = new BookDao().insert(vo);

		System.out.println(result ? "Book 항목 입력 성공 ! " : "입력 실패 ㅠ");
	}

	private static void insertCategory(String category_name) {
		CategoryVo vo = null;

		vo = new CategoryVo();
		vo.setGenre(category_name);
		boolean result = new CategoryDao().insert(vo);

		System.out.println(result ? "Category 항목 입력 성공 ! " : "입력 실패 ㅠ");
	}

	// 출력하기, 인자값으로 각자의 Dao로부터 findAll한 결과 리스트 넘겨주기
	private static <T> void showInfo(List<T> list) {
		for (T vo : list) {
			System.out.println(vo);
		}
	}

	private static void division(String table_name) {
		System.out.println("======================");
		System.out.println(table_name + "입니다.");
		System.out.println("======================");
	}

}
