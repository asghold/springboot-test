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
@Table(name="Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1l; 
    @Id
    @Column(name="idCliente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCliente;

    @Column(name="nombre")
    private String nombre;

    @Column(name="activo")
    private boolean activo;

    @OneToMany(mappedBy = "cliente")
    private Collection<ListaCompra> listaCompra;
    
    

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Collection<ListaCompra> getListaCompra() {
        return this.listaCompra;
    }

    public void setListaCompra(Collection<ListaCompra> listaCompra) {
        this.listaCompra = listaCompra;
    }

}
