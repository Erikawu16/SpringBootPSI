package com.example.psi.model.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.example.psi.model.po.Order;
import com.example.psi.model.po.Purchase;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
	
	private Long id; // 員工序號
	private String name; // 員工姓名
	
	private DepartmentDto department;
	private Set<PurchaseDto> purchases = new LinkedHashSet<>();
	
}
