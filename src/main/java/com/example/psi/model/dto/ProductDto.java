package com.example.psi.model.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.example.psi.model.po.PurchaseItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	private Long id; // 商品序號
	private String name; // 商品名稱
	private Integer cost; // 商品成本
	private Integer price; // 商品定價
	
	private Set<PurchaseItem> purchaseItems = new LinkedHashSet<>();
}
