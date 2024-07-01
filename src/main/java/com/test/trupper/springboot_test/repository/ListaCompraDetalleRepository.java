package com.test.trupper.springboot_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.trupper.springboot_test.entities.ListaCompraDetalle;
import com.test.trupper.springboot_test.entities.ListaCompraDetallePK;

public interface ListaCompraDetalleRepository extends JpaRepository<ListaCompraDetalle, ListaCompraDetallePK> {

}
