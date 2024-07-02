package com.test.trupper.springboot_test.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1l; 
    @Id
    @Column(name="idCliente")
    private Integer idCliente;

    @Column(name="nombre")
    private String nombre;

    @Column(name="activo")
    private boolean activo;

    @OneToMany(mappedBy = "cliente")
    private List<ListaCompra> listaCompras;
    
    public Integer getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Integer idCliente) {
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

    public List<ListaCompra> getListaCompras() {
        return this.listaCompras;
    }

    public void setListaCompras(List<ListaCompra> listaCompras) {
        this.listaCompras= listaCompras;
    }
    

}
