package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.OrderBookDao;
import com.douzone.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {

	public static void main(String[] args) {
			findAllTest();
//		insertTest();
		
	}

	private static void findAllTest() {

		List<OrderBookVo> list = new OrderBookDao().findAll();
		
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {

		OrderBookVo vo = null;
		
		
		vo = new OrderBookVo();
		vo.setBook_no(1);
		vo.setAmount(2);
		vo.setOrder_no(1);
		new OrderBookDao().insert(vo);
		
		
		vo = new OrderBookVo();
		vo.setBook_no(3);
		vo.setAmount(1);
		vo.setOrder_no(2);
		new OrderBookDao().insert(vo);
		
		
		
	}
	
		
}



