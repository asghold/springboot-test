package com.test.trupper.springboot_test.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComprasDto implements Serializable {

    private static final long serialVersionUID = 1l;

    private Integer cliente;
    private String nombreLista;
    private List<DetalleDto> detalle;
    

}
