package com.test.trupper.springboot_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.trupper.springboot_test.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    
} 
