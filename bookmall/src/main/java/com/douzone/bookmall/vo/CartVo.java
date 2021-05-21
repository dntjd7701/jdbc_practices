package com.douzone.bookmall.vo;

public class CartVo {
	private int amount;
	private Long book_no;
	private Long customer_no;
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	
	
	@Override
	public String toString() {
		return "CartVo [amount=" + amount + ", book_no=" + book_no + ", customer_no=" + customer_no + "]";
	}
	
	

}
