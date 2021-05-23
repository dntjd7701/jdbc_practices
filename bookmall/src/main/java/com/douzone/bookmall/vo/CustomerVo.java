package com.douzone.bookmall.vo;

public class CustomerVo {
	
	private int no;
	private String name;
	private String number;
	private String email;
	private String password;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
//		return "CustomerVo [no=" + no + ", name=" + name + ", number=" + number + ", email=" + email + ", password="
//				+ password + "]";
		
		return "[" + no + "] 고객 정보 ) 이름 : " + name + ", 번호 : " + number + ", email : " + email + ", 비밀번호 : " + password; 
	}
	
	
	

}
