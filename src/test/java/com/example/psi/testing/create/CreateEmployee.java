package com.example.psi.testing.create;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.psi.model.dto.EmployeeDto;
import com.example.psi.service.EmployeeService;

@SpringBootTest
public class CreateEmployee {
	@Autowired
	private EmployeeService employeeService;
	
	// 模擬 controller 新增員工
	@Test
	public void addTest() {
		
		EmployeeDto emp1 = new EmployeeDto();
		emp1.setName("劉一");
		
		EmployeeDto emp2 = new EmployeeDto();
		emp2.setName("陳二");
		
		EmployeeDto emp3 = new EmployeeDto();
		emp3.setName("張三");
		
		EmployeeDto emp4 = new EmployeeDto();
		emp4.setName("李四");
		
		EmployeeDto emp5 = new EmployeeDto();
		emp5.setName("王五");
		
		EmployeeDto emp6 = new EmployeeDto();
		emp6.setName("趙六");
		
		EmployeeDto emp7 = new EmployeeDto();
		emp7.setName("孫七");
		
		EmployeeDto emp8 = new EmployeeDto();
		emp8.setName("周八");
		
		EmployeeDto emp9 = new EmployeeDto();
		emp9.setName("吳九");
		
		EmployeeDto emp10 = new EmployeeDto();
		emp10.setName("鄭十");
		
		// 儲存
		employeeService.add(emp1, 1L);
		employeeService.add(emp2, 2L);
		employeeService.add(emp3, 2L);
		employeeService.add(emp4, 3L);
		employeeService.add(emp5, 3L);
		employeeService.add(emp6, 3L);
		employeeService.add(emp7, 1L);
		employeeService.add(emp8, 2L);
		employeeService.add(emp9, 3L);
		employeeService.add(emp10, 3L);
		
		System.out.println("Save OK !");
	}
	
}
