package com.test.trupper.springboot_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.trupper.springboot_test.entities.ListaCompra;

public interface ListaComprasRepository extends JpaRepository<ListaCompra, Integer> {

}
