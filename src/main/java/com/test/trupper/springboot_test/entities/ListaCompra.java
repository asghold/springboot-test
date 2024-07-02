package com.test.trupper.springboot_test.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "ListaCompra")
public class ListaCompra implements Serializable{

    private static final long serialVersionUID = 1l; 

    @Id
    @Column(name = "idLista")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idLista;

    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIME)
    private Date fechaRegistro;

    @Column(name = "fechaUltimaActualizacion")
    @Temporal(TemporalType.TIME)
    private Date fechaUltimaActualizacion;
    
    @Column(name = "activo")
    private boolean activo;

    @Column(name= "nombre")
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "listaCompra")
    private List<ListaCompraDetalle> listaCompraDetalles;

    public Integer getIdLista() {
        return this.idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaUltimaActualizacion() {
        return this.fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ListaCompraDetalle> getListaCompraDetalles() {
        return this.listaCompraDetalles;
    }

    public void setListaCompraDetalles(List<ListaCompraDetalle> listaCompraDetalles) {
        this.listaCompraDetalles = listaCompraDetalles;
    }
    

}
