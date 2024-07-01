package com.test.trupper.springboot_test.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListaComprasDto implements Serializable{

    private static final long serialVersionUID=1l;

    private Integer idLista;
    private ClienteDto clienteDto;
    private String nombre;
    private Date fechaRegistro;
    private Date fechaUltimaActualizacion;
    private boolean activo;
    private Collection<ListaCompraDetalleDto> listaCompraDetalles;

}
