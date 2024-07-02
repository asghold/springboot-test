package com.test.trupper.springboot_test.service;


import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.test.trupper.springboot_test.model.ComprasDto;
import com.test.trupper.springboot_test.model.DetalleDto;

public interface ComprasService {

    ComprasDto resistraCompra(ComprasDto comprasDto) throws NotFoundException;

    List<ComprasDto> obtenerCompras(Integer idCliente)  throws NotFoundException;

    ComprasDto actualizaCompras(Integer id, List<DetalleDto> detalleDto);

    void eliminaCompra(Integer id) throws NotFoundException;

}
