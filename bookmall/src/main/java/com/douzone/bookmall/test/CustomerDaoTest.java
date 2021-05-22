package com.douzone.bookmall.test;

import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.dao.CustomerDao;
import com.douzone.bookmall.vo.CustomerVo;

public class CustomerDaoTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	
	
	
	private static void findAllTest() {
		List<CustomerVo> list = new CustomerDao().findAll();
		for(CustomerVo vo : list) {
			// toString 값 출력 
			System.out.println(vo);
		}
		
	}



	// 자영, 은영, 우성
	// 010 3523 5656/010 9237 9957/010 5928 7464
	// aaa@naver.com, bbb@gmail.com, ccc@hanmail.com
	// qwerasd, adsfrew, erqwavdz
	private static void insertTest() {
		CustomerVo vo = null;
		
		
		vo = new CustomerVo();
		vo.setName("자영");
		vo.setNumber("010 3523 5435");
		vo.setEmail("aaa@naver.com");
		vo.setPassword("adfasdfa");
		new CustomerDao().insert(vo);
		
		vo = new CustomerVo();
		vo.setName("은영");
		vo.setNumber("010 1242 4355");
		vo.setEmail("bbb@hanmail.com");
		vo.setPassword("qwerzc");
		new CustomerDao().insert(vo);


		vo = new CustomerVo();
		vo.setName("우성");
		vo.setNumber("010 4636 7437");
		vo.setEmail("ccc@gmail.com");
		vo.setPassword("253up8fa");
		new CustomerDao().insert(vo);
		
	
	}

}
