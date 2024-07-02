package com.test.trupper.springboot_test.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListaComprasDto implements Serializable{

    private static final long serialVersionUID=1l;

    private String nombre;
    private Integer idProducto;
    private Integer cantidad;
    private Date fechaRegistro;
    private Date fechaUltimaActualizacion;
    
}
