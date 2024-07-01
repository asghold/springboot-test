package com.test.trupper.springboot_test.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ListaCompra")
public class ListaCompra implements Serializable{

    private static final long serialVersionUID = 1l; 

    @Id
    @Column(name = "idLista")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLista;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Column(name = "fechaUltimaActualizacion")
    private Date fechaUltimaActualizacion;
    
    @Column(name = "activo")
    private boolean activo;
    
    
    @ManyToOne
    @JoinColumn(name= "idCliente")
    private Cliente cliente;

    @OneToMany
    private Collection<ListaCompraDetalle> listaCompraDetalles;



    public int getIdLista() {
        return this.idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Collection<ListaCompraDetalle> getListaCompraDetalles() {
        return this.listaCompraDetalles;
    }

    public void setListaCompraDetalles(Collection<ListaCompraDetalle> listaCompraDetalles) {
        this.listaCompraDetalles = listaCompraDetalles;
    }

    

}
