package com.test.trupper.springboot_test.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDto implements Serializable{

    private static final long serialVersionUID=1l;

    private Integer idCliente;
    private String nombre;
    private boolean activo;


}
