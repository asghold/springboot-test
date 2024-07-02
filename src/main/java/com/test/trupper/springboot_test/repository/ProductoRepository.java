package com.test.trupper.springboot_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.trupper.springboot_test.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

    
} 
