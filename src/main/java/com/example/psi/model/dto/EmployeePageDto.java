package com.example.psi.model.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;

/**
 * EmployeePageDTO 是用於封裝與員工分頁相關信息的數據傳輸對象（DTO）。
 * 這個類提供了必要的信息來支持在前端進行分頁顯示。
 */
@Getter
@Setter
public class EmployeePageDto {
	
	private List<EmployeeDto> employees; // 存儲分頁查詢結果的列表
	private int currentPage; // 當前頁碼
	private int totalPage; // 總頁數
	
    /**
     * 通過從 Page 物件轉換來構造 EmployeePageDTO。
     * @param deptPage Page<EmployeePageDTO> 物件，包含從數據庫查詢到的分頁結果。
     */
	public EmployeePageDto(Page<EmployeeDto> empPageDTO) {
		this.employees = empPageDTO.getContent(); // 獲取當前頁的數據列表
		this.currentPage = empPageDTO.getNumber(); // 獲取當前頁碼
		this.totalPage = empPageDTO.getTotalPages(); // 獲取總頁數
	}
}
