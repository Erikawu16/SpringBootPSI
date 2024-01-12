package com.example.psi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.psi.model.dto.DepartmentDto;
import com.example.psi.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/")
	public String index(@ModelAttribute DepartmentDto departmentDto, Model model) {
		List<DepartmentDto> departmentDtos = departmentService.findAll();
		model.addAttribute("departmentDtos", departmentDtos);
		model.addAttribute("departmentDto", departmentDto);
		return "department";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		DepartmentDto departmentDto = departmentService.getDepartmentById(id);
		model.addAttribute("departmentDto", departmentDto);
		return "department-edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		departmentService.delete(id);
		return "redirect:/department/";
	}
	
	@PostMapping("/")
	public String add(DepartmentDto departmentDto) {
		departmentService.add(departmentDto);
		return "redirect:/department/";
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable("id") Long id, DepartmentDto departmentDto) {
		departmentService.update(departmentDto, id);
		return "redirect:/department/";
	}
	
}
