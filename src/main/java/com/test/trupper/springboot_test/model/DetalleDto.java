package com.test.trupper.springboot_test.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DetalleDto implements Serializable {

    private static final long serialVersionUID = 1l;
    
    private Integer idProducto;
    private Integer cantidad;

}
