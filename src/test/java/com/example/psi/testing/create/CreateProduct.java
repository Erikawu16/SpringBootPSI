package com.example.psi.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.psi.model.dto.ProductDto;
import com.example.psi.service.ProductService;

@SpringBootTest
public class CreateProduct {
	@Autowired
	private ProductService productService;
	
	@Test
	public void addTest() {
		ProductDto p1 = new ProductDto();
		p1.setName("百合花");
		p1.setCost(10);
		p1.setPrice(40);
		
		ProductDto p2 = new ProductDto();
		p2.setName("鬱金香");
		p2.setCost(15);
		p2.setPrice(70);
		
		ProductDto p3 = new ProductDto();
		p3.setName("玫瑰");
		p3.setCost(25);
		p3.setPrice(150);
		
		// 儲存
		productService.add(p1);
		productService.add(p2);
		productService.add(p3);
		
		System.out.println("Save OK !");
	}
	
}