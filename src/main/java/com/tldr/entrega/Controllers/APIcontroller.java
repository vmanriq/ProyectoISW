package com.tldr.entrega.Controllers;

import com.tldr.entrega.Entities.Cama;
import com.tldr.entrega.Entities.Pabellon;
import com.tldr.entrega.Services.CamaService;
import com.tldr.entrega.Services.PabellonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class APIcontroller {

    @Autowired
	@Qualifier("PabellonService")
    private PabellonService PabellonServ;

    @Autowired
	@Qualifier("CamaService")
    private CamaService CamaServ;

    @PostMapping("/addPabellon")
    public ResponseEntity<Object> savePabellon(@RequestBody Pabellon objeto){
		if(PabellonServ.create(objeto) == false){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @PostMapping("/addCama")
    public ResponseEntity<Object> saveCama(@RequestBody Cama objeto){
        Pabellon aux = PabellonServ.readById(objeto.getIdpabellon());
        if(aux == null) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		if(CamaServ.create(objeto) == false){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @GetMapping("/Pabellon")
	public ResponseEntity<Object> getPabellonById( 
			@RequestParam(required = true) long id
			){
		Pabellon objeto = PabellonServ.readById(id);
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
    }
    
    @GetMapping("/Cama")
	public ResponseEntity<Object> getCamaById( 
			@RequestParam(required = true) long id
			){
		Cama objeto = CamaServ.readById(id);
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
	}
    
    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
