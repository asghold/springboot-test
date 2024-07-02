package com.test.trupper.springboot_test.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.trupper.springboot_test.entities.Cliente;
import com.test.trupper.springboot_test.entities.ListaCompra;


@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompra, Integer> {

    List<ListaCompra> findByCliente(Cliente cliente);

    ListaCompra findByFechaRegistro(Date fechaRegistro);

}
