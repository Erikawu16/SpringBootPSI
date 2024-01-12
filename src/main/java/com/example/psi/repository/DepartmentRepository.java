package com.example.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.psi.model.po.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
