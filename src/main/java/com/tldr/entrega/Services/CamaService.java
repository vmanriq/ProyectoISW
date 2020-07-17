package com.tldr.entrega.Services;

import com.tldr.entrega.Entities.Cama;
import com.tldr.entrega.Repository.CamaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
      return false;
    }
  }

  // UPDATE
  public boolean update(Cama objeto) {
    try {
      Cama Aux = CamaRepo.findByCamaid( objeto.getCamaid() );
      if( objeto.getOcupado() )
        Aux.setOcupado(false);
      else
        Aux.setOcupado(true);
      CamaRepo.save(Aux);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  // READ
  public Cama readById(Long id) {
    return CamaRepo.findByCamaid(id);
  }
  
  //READ BY "ESTADO"
  public List<Cama> getCamas(boolean estado){
	  return CamaRepo.findByOcupado(estado);
  }
  
  //READ BY "ESTADO"
  public List<Cama> getCamasByPab(boolean estado, Long idpabellon){
	  return CamaRepo.findByOcupadoAndIdpabellon(estado, idpabellon);
  
  }
}