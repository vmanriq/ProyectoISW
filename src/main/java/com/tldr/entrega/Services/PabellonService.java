package com.tldr.entrega.Services;

import com.tldr.entrega.Entities.Pabellon;
import com.tldr.entrega.Repository.PabellonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PabellonService")
public class PabellonService {
    
    @Autowired
    @Qualifier("PabellonRepository")
    private PabellonRepository PabellonRepo;
    
    // CREATE
    public boolean create( Pabellon objeto ) {
		try {
			PabellonRepo.save( objeto );
			return true;
		}catch(Exception e) {
			return false;
		}
    }
    
    // READ
    public Pabellon readById(Long id){
        return PabellonRepo.findByPabellonid(id);
    }
}