package com.example.psi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.psi.model.dto.DepartmentDto;
import com.example.psi.model.dto.EmployeeDto;
import com.example.psi.model.dto.EmployeePageDto;
import com.example.psi.model.po.Employee;
import com.example.psi.service.DepartmentService;
import com.example.psi.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	// page=頁數&size=每頁筆數
	// 例如: page=0&size=5 第 1 頁每頁 5 筆
	// 例如: page=1&size=5 第 2 頁每頁 5 筆
	// 例如: page=2&size=5 第 3 頁每頁 5 筆
	@GetMapping("/")
	public String index(@RequestParam(name = "page", defaultValue = "0") int page, 
						@RequestParam(name = "size", defaultValue = "3") int size,
						@ModelAttribute EmployeeDto employeeDto, Model model) {
		Pageable pageable = PageRequest.of(page, size);
		List<DepartmentDto> departmentDtos = departmentService.findAll();
		EmployeePageDto employeePageDto = employeeService.findAll(pageable); // 得到該分頁的數據實體
		model.addAttribute("departmentDtos", departmentDtos);
		model.addAttribute("employeePageDto", employeePageDto);
		return "employee";
	}
	
	@PostMapping("/")
	public String create(EmployeeDto employeeDto) {
		employeeService.add(employeeDto);
		return "redirect:/employee/";
	}
	
	@GetMapping("/edit/{id}") // 修改頁面的呈現
	public String edit(@PathVariable("id") Long id, Model model) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		model.addAttribute("employeeDto", employeeDto);
		model.addAttribute("departmentDtos", departmentService.findAll());
		return "employee-edit";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, EmployeeDto employeeDto) {
		employeeService.update(employeeDto, id);
		return "redirect:/employee/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
		return "redirect:/employee/";
	}
}
