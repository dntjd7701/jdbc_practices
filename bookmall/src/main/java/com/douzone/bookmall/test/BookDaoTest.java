package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();

	}
	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		BookVo vo = null;
		
		vo = new BookVo();
		vo.setPrice(13320);
		vo.setTitle("하품의 언덕");
		vo.setCategory_no(1);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setPrice(16200);
		vo.setTitle("백신 거부자들");
		vo.setCategory_no(2);
		new BookDao().insert(vo);
		
		vo = new BookVo();
		vo.setPrice(15120);
		vo.setTitle("사는 게 정답이 있으려나?");
		vo.setCategory_no(3);
		new BookDao().insert(vo);
	}
}
