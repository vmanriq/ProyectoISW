package com.tldr.entrega.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cama")
public class Cama implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long camaid;

    @Column(name = "ocupado")
    private boolean ocupado;

    @Column(name = "capacidad")
    private float capacidad;
    
    @Column(name = "idpabellon")
    private Long idpabellon;



    public Long getCamaid() {
        return this.camaid;
    }

    public void setCamaid(Long camaid) {
        this.camaid = camaid;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public boolean getOcupado() {
        return this.ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public float getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }

    public Long getIdpabellon() {
        return this.idpabellon;
    }

    public void setIdpabellon(Long idpabellon) {
        this.idpabellon = idpabellon;
    }

    public Cama(Long camaid, boolean ocupado, float capacidad, Long idpabellon) {
        this.camaid = camaid;
        this.ocupado = ocupado;
        this.capacidad = capacidad;
        this.idpabellon = idpabellon;
    }

    public Cama(){}
}