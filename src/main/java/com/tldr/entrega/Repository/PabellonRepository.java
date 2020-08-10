package com.tldr.entrega.Repository;

import java.util.List;

import com.tldr.entrega.Entities.Pabellon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("PabellonRepository")
public interface PabellonRepository extends JpaRepository<Pabellon, Long>{

    public abstract Pabellon findByPabellonid(Long id);

    @Query("select p.pabellonid from Pabellon p")
    public abstract  List<Long> getAllIds();
    
}