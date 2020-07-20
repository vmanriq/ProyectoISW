package com.tldr.entrega.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pabellon")
public class Pabellon implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pabellonid;

    @Column(name = "capacidad")
    private int capacidad;

    public Long getPabellonid() {
        return this.pabellonid;
    }

    public void setPabellonid(Long pabellonid) {
        this.pabellonid = pabellonid;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Pabellon(Long pabellonid, int capacidad) {
        this.pabellonid = pabellonid;
        this.capacidad = capacidad;
    }

    public Pabellon() {

    }

}