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

    @Column(name = "fecha")
    private Date fecha;



    @Column(name = "comentario")
    private String comentario;

    public Long getRegistroid() {
        return registroid;
    }

    public void setRegistroid(Long registroid) {
        this.registroid = registroid;
    }

    public Long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Long idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Long getIdpabellon() {
        return idpabellon;
    }

    public void setIdpabellon(Long idpabellon) {
        this.idpabellon = idpabellon;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Registro(Long registroid, Long idpaciente, Long idpabellon, Date fecha, String comentario) {
        this.registroid = registroid;
        this.idpaciente = idpaciente;
        this.idpabellon = idpabellon;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    public Registro() {
    }
}