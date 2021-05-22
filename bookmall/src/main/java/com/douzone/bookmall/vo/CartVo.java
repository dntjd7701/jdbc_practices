package com.douzone.bookmall.vo;

public class CartVo {
	private int amount;
	private int book_no;
	private int customer_no;
	private String customer_name;
	private String book_title;
	
	// 출력할 내용 선정부터.
	// 고객명, 책 제목, 수량
	
	public int getAmount() {
		return amount;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
	}
	@Override
	public String toString() {
	return "현재 " + customer_name +"님의 장바구니에 담긴 책 :" + "[책 제목=" + book_title + ", 수량=" + amount + "]";
	}
	
	

}
