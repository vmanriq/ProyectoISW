package com.tldr.entrega.Services;

import java.util.Date;

import com.tldr.entrega.Entities.Registro;
import com.tldr.entrega.Repository.RegistroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("RegistroService")
public class RegistroService {

    @Autowired
    @Qualifier("RegistroRepository")
    private RegistroRepository RegistroRepo;

    // CREATE
    public boolean create(Registro objeto) {
        try {
            Date fechaentrada = new Date();
            objeto.setFechaentrada(fechaentrada);
            RegistroRepo.save(objeto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // UPDATE
    public boolean update(Registro objeto) {
        try {
            Date fechasalida = new Date();
            Registro Aux = RegistroRepo.findByRegistroid( objeto.getRegistroid() );
            Aux.setFechasalida(fechasalida);
            RegistroRepo.save(Aux);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}