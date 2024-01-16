package com.example.psi.testing.create;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.psi.model.dto.EmployeeDto;
import com.example.psi.model.dto.ProductDto;
import com.example.psi.model.dto.PurchaseDto;
import com.example.psi.model.dto.PurchaseItemDto;
import com.example.psi.model.dto.SupplierDto;
import com.example.psi.service.EmployeeService;
import com.example.psi.service.ProductService;
import com.example.psi.service.PurchaseService;
import com.example.psi.service.SupplierService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CreatePurchase {
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	ProductService productService;
	
	@Transactional
	@Commit
	@Test
	public void test() {
		// 資料預備
		// Purchase 部門的員工 Bob 對 富貴芬芳 採購 百合花 100 朵 與 鬱金香 200 朵
		SupplierDto s1 = supplierService.getSupplierById(1L); // 富貴芬芳
		EmployeeDto e4 = employeeService.getEmployeeById(4L); // Bob
		ProductDto p1 = productService.getProductById(1L); // 百合花
		ProductDto p2 = productService.getProductById(2L); // 鬱金香
		
		// 建立採購單
		PurchaseDto pu = new PurchaseDto();
		pu.setDate(new Date());  // 設定採購日期
		// 配置關聯
		pu.setSupplier(s1); // 配置供應商: 富貴芬芳
		pu.setEmployee(e4); // 配置員工: Bob
		
		// 建立採購明細 1
		PurchaseItemDto pi1 = new PurchaseItemDto();
		pi1.setAmount(100); // 數量 100 朵
		// 配置關聯
		pi1.setPurchase(pu); // 配置採購單(此採購明細是隸屬於哪一個採購單)
		pi1.setProduct(p1); // 配置商品(此採購明細要購買的商品)
		
		// 建立採購明細 2
		PurchaseItemDto pi2 = new PurchaseItemDto();
		pi2.setAmount(200); // 數量 200 朵
		// 配置關聯
		pi2.setPurchase(pu); // 配置採購單(此採購明細是隸屬於哪一個採購單)
		pi2.setProduct(p2); // 配置商品(此採購明細要購買的商品)
		
		// 保存
		Long pid = purchaseService.add(pu); // 採購單(主檔)
		purchaseService.addItem(pi1, pid); // 採購單明細(明細檔)
		purchaseService.addItem(pi2, pid); // 採購單明細(明細檔)
	} 
}
