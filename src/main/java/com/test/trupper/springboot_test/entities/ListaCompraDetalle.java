package com.test.trupper.springboot_test.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ListaCompraDetalle")
@IdClass(ListaCompraDetallePK.class)
public class ListaCompraDetalle implements Serializable{

    private static final long serialVersionUID = 1l; 

    @Id
    @Column(name = "idListaCompra")
    private int idListaCompra;

    @Id
    @Column(name = "codigoProducto")
    private int codigoProducto;

    @ManyToOne
    @JoinColumn(name = "idLista")
    private ListaCompra listaCompra;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;


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

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
