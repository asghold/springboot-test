package com.test.trupper.springboot_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.trupper.springboot_test.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    
} 
