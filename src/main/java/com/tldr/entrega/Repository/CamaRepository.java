package com.tldr.entrega.Repository;

import com.tldr.entrega.Entities.Cama;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CamaRepository")
public interface CamaRepository extends JpaRepository<Cama, Long>{
    
    public abstract Cama findByCamaid(Long id);
}