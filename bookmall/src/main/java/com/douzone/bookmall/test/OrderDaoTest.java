package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.OrderDao;
import com.douzone.bookmall.vo.OrderVo;

public class OrderDaoTest {

	// 일단 주문 목록은 2개만 
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
		
	}

	private static void insertTest() {
		OrderVo vo = null;
		
		
		vo = new OrderVo();
		vo.setOrderNo(23432);
		vo.setAddress("해운대");
		vo.setCustomer_no(3);
		new OrderDao().insert(vo);
		
		

		vo = new OrderVo();
		vo.setOrderNo(113817);
		vo.setAddress("세종");
		vo.setCustomer_no(2);
		new OrderDao().insert(vo);
		
		
	}

}
