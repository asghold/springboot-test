package com.test.trupper.springboot_test.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ListaCompraDetalle")
public class ListaCompraDetalle implements Serializable{

    private static final long serialVersionUID = 1l; 

    @EmbeddedId
    private ListaCompraDetallePK id;

    @ManyToOne
    @JoinColumn(name = "idLista")
    private ListaCompra listaCompra;

    @ManyToOne
    @JoinColumn(name = "idCodigoProducto")
    private Producto producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    public ListaCompraDetallePK getId() {
        return this.id;
    }

    public void setId(ListaCompraDetallePK id) {
        this.id = id;
    }

    public ListaCompra getListaCompra() {
        return this.listaCompra;
    }

    public void setListaCompra(ListaCompra listaCompra) {
        this.listaCompra = listaCompra;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    
}
