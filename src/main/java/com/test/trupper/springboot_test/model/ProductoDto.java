package com.test.trupper.springboot_test.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class ProductoDto implements Serializable{

    private static final long serialVersionUID=1l;

    private Integer idProducto;
    private String clave;
    private String descripcion;
    private boolean activo;

}
