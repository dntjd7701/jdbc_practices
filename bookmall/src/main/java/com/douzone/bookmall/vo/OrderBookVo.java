package com.douzone.bookmall.vo;

public class OrderBookVo {
	
	private int book_no;
	private String book_title;
	

	private int book_price;
	private int amount;
	private int order_no;
	private int orderNo;
	
	
	
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return "OrderBookVo [책번호=" + book_no + ", 제목=" + book_title + ", 가격=" + book_price + ", 수량=" + amount
				+ ", 주문번호=" + orderNo + "]";
	}
	

}
