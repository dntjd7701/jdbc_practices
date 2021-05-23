package com.douzone.bookmall.vo;

public class BookVo {
	
	
	private int no;
	private int price;
	private String title;
	private int category_no;
	private String genre;
	
	
	
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	@Override
	public String toString() {
//		return "BookVo [no=" + no + ", price=" + price + ", title=" + title + ", genre=" + genre + "]";
		return "[" + no + "] 책 정보 ) 제목 : " + title + ", 가격 : " + price + ", 장르 : " + genre; 
	}

	
	

}
