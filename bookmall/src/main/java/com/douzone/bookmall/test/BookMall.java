package com.douzone.bookmall.test;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("========회원========");
		
		
		
		System.out.println("========카테고리========");
		CategoryDao category = new CategoryDao().insert();
		category.insert();
		category.insert();
		category.insert();
		List list = category.findAll();
		for(CategoryVo vo : list) {
			//toString ok
			
			System.out.println(vo);
		}

		
		
		
		
	}

}
