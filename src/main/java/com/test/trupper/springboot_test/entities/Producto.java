package com.test.trupper.springboot_test.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1l; 

    @Id
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name="clave")
    private String clave;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="activo")
    private boolean activo;

    @OneToMany(mappedBy = "producto")
    private List<ListaCompraDetalle> listaCompraDetalles;


    public Integer getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return this.activo;
    }

    public boolean getActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<ListaCompraDetalle> getListaCompraDetalles() {
        return this.listaCompraDetalles;
    }

    public void setListaCompraDetalles(List<ListaCompraDetalle> listaCompraDetalles) {
        this.listaCompraDetalles = listaCompraDetalles;
    }
    
    
}
