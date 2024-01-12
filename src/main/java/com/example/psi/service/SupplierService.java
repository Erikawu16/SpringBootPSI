package com.example.psi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psi.model.dto.SupplierDto;
import com.example.psi.model.po.Supplier;
import com.example.psi.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 新增
	public void add(SupplierDto supplierDto) {
		Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
		supplierRepository.save(supplier);
	}
	
	// 修改
	public void update(SupplierDto supplierDto, Long id) {
		Optional<Supplier> supplierOpt = supplierRepository.findById(id);
		if(supplierOpt.isPresent()) {
			Supplier supplier = supplierOpt.get();
			supplier.setName(supplierDto.getName());
			supplierRepository.save(supplier);
		} 
	}
	
	// 刪除
	public void delete(Long id) {
		Optional<Supplier> supplierOpt = supplierRepository.findById(id);
		if(supplierOpt.isPresent()) {
			supplierRepository.delete(supplierOpt.get());
		} 
	}
	
	// 查詢單筆
	public SupplierDto getSupplierById(Long id) {
		Optional<Supplier> supplierOpt = supplierRepository.findById(id);
		if(supplierOpt.isPresent()) {
			Supplier supplier = supplierOpt.get();
			SupplierDto supplierDto = modelMapper.map(supplier, SupplierDto.class);
			return supplierDto;
		}
		return null;
	}
	
	// 全部查詢
	public List<SupplierDto> findAll() {
		List<Supplier> suppliers = supplierRepository.findAll();
		return suppliers.stream()
						  .map(supplier -> modelMapper.map(supplier, SupplierDto.class))
						  .toList();
	}
	
}