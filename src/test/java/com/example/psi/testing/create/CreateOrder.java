package com.example.psi.testing.create;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.psi.model.dto.CustomerDto;
import com.example.psi.model.dto.EmployeeDto;
import com.example.psi.model.dto.OrderDto;
import com.example.psi.model.dto.OrderItemDto;
import com.example.psi.model.dto.ProductDto;
import com.example.psi.service.CustomerService;
import com.example.psi.service.EmployeeService;
import com.example.psi.service.OrderService;
import com.example.psi.service.ProductService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CreateOrder {
	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@Transactional
	@Commit
	@Test
	public void test() {
		// 資料預備
		// Sales 部門的員工 John 得到客戶 王曉明 的訂單 百合花 15 朵 與 鬱金香 12 朵
		CustomerDto c1 = customerService.getCustomerById(1L);
		EmployeeDto e1 = employeeService.getEmployeeById(1L);
		ProductDto p1 = productService.getProductById(1L);
		ProductDto p2 = productService.getProductById(2L);
		
		// 建立訂單
		OrderDto order = new OrderDto();
		order.setDate(new Date()); // 訂單日期
		// 配置關聯
		order.setCustomer(c1); // 配置客戶 王曉明
		order.setEmployee(e1); // 配置員工 John
		
		// 建立訂單明細 1
		OrderItemDto oi1 = new OrderItemDto();
		oi1.setAmount(15); // 購買數量
		// 配置關聯
		oi1.setOrder(order); // 配置訂購單(此訂購明細是隸屬於哪一個訂購單)
		oi1.setProduct(p1);  // 配置商品(此訂購明細要訂購的商品)
		
		// 建立訂單明細 2
		OrderItemDto oi2 = new OrderItemDto();
		oi2.setAmount(12); // 購買數量
		// 配置關聯
		oi2.setOrder(order); // 配置訂購單(此訂購明細是隸屬於哪一個訂購單)
		oi2.setProduct(p2);  // 配置商品(此訂購明細要訂購的商品)
		
		// 保存
		Long oid = orderService.add(order);
		orderService.addItem(oi1, oid);
		orderService.addItem(oi2, oid);
	}
}
