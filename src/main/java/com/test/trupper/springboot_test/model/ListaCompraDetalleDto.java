package com.test.trupper.springboot_test.model;

import java.io.Serializable;

public class ListaCompraDetalleDto implements Serializable{

    private static final long serialVersionUID=1l;

    private Integer idListaCompra;
    private Integer codigoProducto;
    private ListaComprasDto listaComprasDto;
    private ProductoDto productoDto;
    private Integer cantidad;    

}
