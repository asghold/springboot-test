package com.test.trupper.springboot_test.entities;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1l; 

    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProducto;

    @Column(name="clave")
    private String clave;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="activo")
    private boolean activo;

    @OneToMany
    private Collection<ListaCompraDetalle> listaCompraDetalles;

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
    
}
