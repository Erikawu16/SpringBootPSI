package com.example.psi.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.psi.model.dto.CustomerDto;
import com.example.psi.service.CustomerService;

@SpringBootTest
public class CreateCustomer {
	@Autowired
	private CustomerService customerService;
	
	@Test
	public void addTest() {
		CustomerDto c1 = new CustomerDto();
		c1.setName("客戶一");
		CustomerDto c2 = new CustomerDto();
		c2.setName("客戶二");
		CustomerDto c3 = new CustomerDto();
		c3.setName("客戶三");
		CustomerDto c4 = new CustomerDto();
		c4.setName("客戶四");
		CustomerDto c5 = new CustomerDto();
		c5.setName("客戶五");
		
		// 儲存
		customerService.add(c1);
		customerService.add(c2);
		customerService.add(c3);
		customerService.add(c4);
		customerService.add(c5);
		
		System.out.println("Save OK !");
	}
	
}