package com.example.psi.model.po;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supplier")
@Getter
@Setter
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 供應商序號
	
	@Column
	private String name; // 供應商名稱
	
	@OneToMany(mappedBy = "supplier")
	@OrderBy("id ASC")
	private Set<Purchase> purchases = new LinkedHashSet<>();

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + "]";
	}
	
}
