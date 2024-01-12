package com.example.psi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psi.model.dto.DepartmentDto;
import com.example.psi.model.po.Department;
import com.example.psi.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 新增
	/**
	 * 對於單表新增操作，是否使用 @Transactional 取決於您對應用的整體設計和未來可能的擴展。
	 * 在許多情況下，為了保持一致性和方便未來擴展，使用 @Transactional 是一個合理的選擇。*/
	@Transactional
	public void add(DepartmentDto departmentDto) {
		// 將 departmentDTO 轉 department
		Department department = modelMapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
	}
	
	// 修改
	@Transactional
	public void update(DepartmentDto departmentDto, Long id) {
		Optional<Department> departmentOpt = departmentRepository.findById(id);
		if(departmentOpt.isPresent()) {
			Department department = departmentOpt.get();
			department.setName(departmentDto.getName());
			departmentRepository.save(department);
		} 
	}
	
	// 刪除
	@Transactional
	public void delete(Long id) {
		Optional<Department> departmentOpt = departmentRepository.findById(id);
		if(departmentOpt.isPresent()) {
			departmentRepository.delete(departmentOpt.get());
		} 
	}
	
	// 查詢單筆
	public DepartmentDto getDepartmentById(Long id) {
		Optional<Department> departmentOpt = departmentRepository.findById(id);
		if(departmentOpt.isPresent()) {
			Department department = departmentOpt.get();
			// department 轉 departmentDto
			DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
			return departmentDto;
		}
		return null;
	}
	
	// 全部查詢
	public List<DepartmentDto> findAll() {
		List<Department> departments = departmentRepository.findAll();
		return departments.stream()
						  .map(department -> modelMapper.map(department, DepartmentDto.class))
						  /*
						  .map(department -> {
							  DepartmentDto dto = new DepartmentDto();
							  dto.setId(department.getId());
							  dto.setName(department.getName());
							  
							  Set<EmployeeDto> empDtos = new LinkedHashSet<>();
							  for(Employee emp : department.getEmployees()) {
								  EmployeeDto empDto = new EmployeeDto();
								  empDto.setId(emp.getId());
								  empDto.setName(emp.getName());
								  empDtos.add(empDto);
							  }
							  dto.setEmployees(empDtos);
							  
							  return dto;
						  })
						  */
						  .toList();
	}
	
}
