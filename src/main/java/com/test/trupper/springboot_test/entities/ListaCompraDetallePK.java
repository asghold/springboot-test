package com.test.trupper.springboot_test.entities;

import java.io.Serializable;

import jakarta.persistence.Column;

public class ListaCompraDetallePK implements Serializable {

    @Column(name = "idListaCompra")
    private Integer idListaCompra;

    @Column(name="codigoProducto")
    private Integer codigoProducto;

    public Integer getIdListaCompra() {
        return this.idListaCompra;
    }

    public void setIdListaCompra(Integer idListaCompra) {
        this.idListaCompra = idListaCompra;
    }

    public Integer getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public boolean equals(Object other){
        if(this == other) {
            return true;
        }
        ListaCompraDetallePK castOther = (ListaCompraDetallePK) other;
        return this.idListaCompra.equals(castOther.idListaCompra)
            && this.codigoProducto.equals(castOther.codigoProducto);
    }

}
