package com.douzone.bookmall.vo;

public class OrderBookVo {
	
	private Long book_no;
	private Long order_no;
	private Long amount;
	private Long price;
	
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "OrderBookVo [book_no=" + book_no + ", order_no=" + order_no + ", amount=" + amount + ", price=" + price
				+ "]";
	}
	
	
	
	

}
