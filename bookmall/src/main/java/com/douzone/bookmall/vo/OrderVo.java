package com.douzone.bookmall.vo;

public class OrderVo {
	
	private Long no;
	private Long orderNo;
	private Long price;
	private String address;
	private Long customer_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(Long customer_no) {
		this.customer_no = customer_no;
	}
	
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", orderNo=" + orderNo + ", price=" + price + ", address=" + address
				+ ", customer_no=" + customer_no + "]";
	}
	
	
	
	

}
