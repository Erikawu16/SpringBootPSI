package com.example.psi.model.po;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 員工序號
	
	@Column
	private String name; // 員工姓名
	
	@JoinColumn(name = "department_id") // 外鍵(部門序號)
	@ManyToOne
	private Department department;
	
	@OneToMany(mappedBy = "employee")
	@OrderBy("id ASC")
	private Set<Purchase> purchases = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "employee")
	@OrderBy("id ASC")
	private Set<Order> orders = new LinkedHashSet<>();

	
	
}
