package com.tldr.entrega.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registro")
public class Registro implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registroid;

    @Column(name = "idpaciente")
    private Long idpaciente;

    @Column(name = "idpabellon")
    private Long idpabellon;

    @Column(name = "fechaentrada")
    private Date fechaentrada;

    @Column(name = "fechasalida")
    private Date fechasalida;

    public Long getRegistroid() {
        return this.registroid;
    }

    public void setRegistroid(Long registroid) {
        this.registroid = registroid;
    }

    public Long getIdpaciente() {
        return this.idpaciente;
    }

    public void setIdpaciente(Long idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Long getIdpabellon() {
        return this.idpabellon;
    }

    public void setIdpabellon(Long idcama) {
        this.idpabellon = idcama;
    }

    public Date getFechaentrada() {
        return this.fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return this.fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Registro(Long registroid, Long idpaciente, Long idpabellon, Date fechaentrada, Date fechasalida) {
        this.registroid = registroid;
        this.idpaciente = idpaciente;
        this.idpabellon = idpabellon;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public Registro() {
    }
}