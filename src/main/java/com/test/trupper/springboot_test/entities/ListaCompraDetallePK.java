package com.test.trupper.springboot_test.entities;

import java.io.Serializable;

import jakarta.persistence.Column;


public class ListaCompraDetallePK implements Serializable {

    @Column(name = "idListaCompra")
    private int idListaCompra;

    @Column(name="codigoProducto")
    private int codigoProducto;



    public int getIdListaCompra() {
        return this.idListaCompra;
    }

    public void setIdListaCompra(int idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    public int getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

}
