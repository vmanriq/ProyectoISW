package com.tldr.entrega.Services;

import com.tldr.entrega.Entities.Cama;
import com.tldr.entrega.Repository.CamaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("CamaService")
public class CamaService {

  @Autowired
  @Qualifier("CamaRepository")
  private CamaRepository CamaRepo;

  // CREATE
  public boolean create(Cama objeto) {
    try {
      CamaRepo.save(objeto);
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  // READ
  public Cama readById(Long id) {
    return CamaRepo.findByCamaid(id);
  }
}