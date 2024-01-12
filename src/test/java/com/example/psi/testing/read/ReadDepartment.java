package com.example.psi.testing.read;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.psi.model.dto.DepartmentDto;
import com.example.psi.model.po.Department;
import com.example.psi.repository.DepartmentRepository;
import com.example.psi.service.DepartmentService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ReadDepartment {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//@Transactional
	//@Test
	public void readOne() {
		System.out.println("readOne:");
		DepartmentDto departmentDTO = departmentService.getDepartmentById(1L);
		System.out.println("id: " + departmentDTO.getId());
		System.out.println("name: " + departmentDTO.getName());
		System.out.println("employee size: " + departmentDTO.getEmployees().size());
	}
	
	//@Transactional // 在測試的時候若 fetch = FetchType.LAZY, 要加上 @Transactional
	//@Test
	public void readOne2() {
		System.out.println("readOne2:");
		Department department = departmentRepository.findById(1L).get();
		System.out.println("id: " + department.getId());
		System.out.println("name: " + department.getName());
		System.out.println("employee size: " + department.getEmployees().size());
	}
	
	@Transactional
	@Test
	public void readAll() {
		System.out.println("readAll:");
		List<DepartmentDto> departmentDTOs = departmentService.findAll();
		for(DepartmentDto departmentDTO : departmentDTOs) {
			System.out.println("id: " + departmentDTO.getId());
			System.out.println("name: " + departmentDTO.getName());
			System.out.println("employee size: " + departmentDTO.getEmployees().size());
		}
	}
	
	//@Transactional
	//@Test
	public void readAll2() {
		System.out.println("readAll2:");
		List<Department> departments = departmentRepository.findAll();
		for(Department department : departments) {
			System.out.println("id: " + department.getId());
			System.out.println("name: " + department.getName());
			System.out.println("employee size: " + department.getEmployees().size());
		}
	}
}
