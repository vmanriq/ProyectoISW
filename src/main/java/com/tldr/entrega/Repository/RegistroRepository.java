package com.tldr.entrega.Repository;

import com.tldr.entrega.Entities.Registro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RegistroRepository")
public interface RegistroRepository extends JpaRepository<Registro, Long>{

    public abstract Registro findByRegistroid(Long idcama);
    
}