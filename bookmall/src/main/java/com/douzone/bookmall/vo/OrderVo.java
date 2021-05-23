package com.douzone.bookmall.vo;

public class OrderVo {
	
//	select o.no, o.orderno,c.name, o.address, ob.amount
//	, (ob.amount * b.price) as total 
	
//from order_ o, orderbook ob, customer c, book b 
	
//where o.no = ob.order_no
//	and c.no = o.customer_no 
//	and b.no = ob.book_no;
	
// 번호, 주문번호, 고객명, 배송지, 수량, 총 가격 
	
	private int order_no;
	private int orderNo;
	private String customer_name;
	private String address;
	private int orderBook_amount;
	private int totalPrice;
	
	private int customer_no;
	
	public int getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(int customer_no) {
		this.customer_no = customer_no;
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
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOrderBook_amount() {
		return orderBook_amount;
	}
	public void setOrderBook_amount(int orderBook_amount) {
		this.orderBook_amount = orderBook_amount;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
//		return "OrderVo [번호=" + order_no + ", 주문번호=" + orderNo + ", 고객명=" + customer_name
//				+ ", 배송지=" + address + ", 수량=" + orderBook_amount + ", 총금액=" + totalPrice
//				+ "]";
		
		return "[" + order_no + "] 주문 정보 ) 주문번호 : " + orderNo + ", 고객명 : " + customer_name + ", 배송지 : " + address
				+ ", 수량=" + orderBook_amount + ", 총금액=" + totalPrice;
	}
	
	
	
	
	

}
