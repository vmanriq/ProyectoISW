package com.tldr.entrega.Controllers;

import com.tldr.entrega.Entities.Pabellon;
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

    @PostMapping("/addPabellon")
    public ResponseEntity<Object> save(@RequestBody Pabellon objeto){
		if(PabellonServ.create(objeto) == false){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @GetMapping("/Pabellon")
	public ResponseEntity<Object> getAnimeById( 
			@RequestParam(required = true) long id
			){
		Pabellon objeto = PabellonServ.readById(id);
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
