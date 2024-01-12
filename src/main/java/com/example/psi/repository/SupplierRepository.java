package com.example.psi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.psi.model.po.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}