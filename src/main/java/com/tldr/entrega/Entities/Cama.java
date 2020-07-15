package com.tldr.entrega.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne
    @JoinColumn(name="pabellonid", nullable=false)
    private Pabellon pabellon;


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

    public Pabellon getPabellon() {
        return this.pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    public Cama(Long camaid, boolean ocupado, float capacidad, Pabellon pabellon) {
        this.camaid = camaid;
        this.ocupado = ocupado;
        this.capacidad = capacidad;
        this.pabellon = pabellon;
    }

    public Cama(){
        
    }

}