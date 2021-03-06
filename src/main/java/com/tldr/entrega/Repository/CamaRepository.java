package com.tldr.entrega.Repository;

import java.util.List;

import com.tldr.entrega.Entities.Cama;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CamaRepository")
public interface CamaRepository extends JpaRepository<Cama, Long>{
    
    public abstract Cama findByCamaid(Long id);

    public abstract List<Cama> findByOcupado(boolean estado);

    public abstract List<Cama> findByIdpabellon(Long idpabellon);

    public abstract List<Cama> findByOcupadoAndIdpabellon(boolean estado, Long idpabellon);
}