package com.example.psi.testing.read;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.psi.model.dto.EmployeeDto;
import com.example.psi.model.dto.EmployeePageDto;
import com.example.psi.service.EmployeeService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ReadEmployee {
	
	@Autowired
	private EmployeeService employeeService;
	
	//@Autowired
	//private DepartmentRepository departmentRepository;
	
	@Transactional
	@Test
	public void readAll() {
		System.out.println("readOne:");
		Pageable pageable = PageRequest.of(0, 3);
		EmployeePageDto employeePageDTO = employeeService.findAll(pageable); // 得到該分頁的數據實體
		for(EmployeeDto employeeDTO : employeePageDTO.getEmployees()) {
			System.out.println("id: " + employeeDTO.getId());
			System.out.println("name: " + employeeDTO.getName());
			System.out.println("department: " + employeeDTO.getDepartment().getName());
		}
	}
	
}
