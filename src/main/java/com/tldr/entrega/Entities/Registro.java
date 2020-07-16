package com.tldr.entrega.Entities;

import java.io.Serializable;
import java.sql.Date;

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

    @Column(name = "idcama")
    private Long idcama;

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

    public Long getIdcama() {
        return this.idcama;
    }

    public void setIdcama(Long idcama) {
        this.idcama = idcama;
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

    public Registro(Long registroid, Long idpaciente, Long idcama, Date fechaentrada, Date fechasalida) {
        this.registroid = registroid;
        this.idpaciente = idpaciente;
        this.idcama = idcama;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
    }

    public Registro() {
    }
}