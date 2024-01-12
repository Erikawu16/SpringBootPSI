package com.example.psi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.psi.model.dto.ProductDto;
import com.example.psi.model.po.Product;
import com.example.psi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// 新增
	public void add(ProductDto productDto) {
		Product product = modelMapper.map(productDto, Product.class);
		productRepository.save(product);
	}
	
	// 修改
	public void update(ProductDto productDto, Long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			product.setName(productDto.getName());
			product.setCost(productDto.getCost());
			product.setPrice(productDto.getPrice());
			productRepository.save(product);
		} 
	}
	
	// 刪除
	public void delete(Long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			productRepository.delete(productOpt.get());
		} 
	}
	
	// 查詢單筆
	public ProductDto getProductById(Long id) {
		Optional<Product> productOpt = productRepository.findById(id);
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			ProductDto productDto = modelMapper.map(product, ProductDto.class);
			return productDto;
		}
		return null;
	}
	
	// 全部查詢
	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		return products.stream()
						  .map(product -> modelMapper.map(product, ProductDto.class))
						  .toList();
	}
	
}