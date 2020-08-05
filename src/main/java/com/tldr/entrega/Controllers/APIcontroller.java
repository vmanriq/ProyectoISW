package com.tldr.entrega.Controllers;

import com.tldr.entrega.Entities.Cama;
import com.tldr.entrega.Entities.Pabellon;
import com.tldr.entrega.Entities.Registro;
import com.tldr.entrega.Services.CamaService;
import com.tldr.entrega.Services.PabellonService;

import com.tldr.entrega.Services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class APIcontroller {

    @Autowired
	@Qualifier("PabellonService")
    private PabellonService PabellonServ;

    @Autowired
	@Qualifier("CamaService")
    private CamaService CamaServ;

	@Autowired
	@Qualifier("RegistroService")
	private RegistroService RegistroServ;



    @PostMapping("/addPabellon")
    public ResponseEntity<Object> savePabellon(@RequestBody final Pabellon objeto){
		if(PabellonServ.create(objeto) == false){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @PostMapping("/addCama")
    public ResponseEntity<Object> saveCama(@RequestBody final Cama objeto){
        final Pabellon aux = PabellonServ.readById(objeto.getIdpabellon());
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
			@RequestParam(required = true) final long id
			){
		final Pabellon objeto = PabellonServ.readById(id);
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
	}
	
	@GetMapping("/PabellonIds")
	public ResponseEntity<Object> getAllPabellonIds( 
			){
		final List<Long> lista = PabellonServ.readAllIds();
		return new ResponseEntity<Object>(lista, HttpStatus.OK);
    }
    
    @GetMapping("/Cama")
	public ResponseEntity<Object> getCamaById( 
			@RequestParam(required = true) final long id
			){
		final Cama objeto = CamaServ.readById(id);
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
	}
    
    
    @GetMapping("/CamasEstado")
	public ResponseEntity<Object> getCamasByEstado( 
			@RequestParam(required = true) final boolean estado
			){
		final List<Cama> objeto = CamaServ.getCamas(estado);
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
	}
    
    @GetMapping("/CamasEstadoPabellon")
	public ResponseEntity<Object> getCamasByEstadoPabellon( 
			@RequestParam(required = false) final String estado, 
			@RequestParam(required = true) final Long idpabellon
			){
		List<Cama> objeto;
		if( estado == null){
			objeto = CamaServ.getAllCamasByPabellon(idpabellon);
		}else{
			boolean b = Boolean.parseBoolean(estado);
			objeto = CamaServ.getCamasByPab(b, idpabellon);
		}
		
		if(objeto == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(objeto, HttpStatus.OK);
	}

	@PutMapping("/AsignarCamaPaciente")
	public ResponseEntity<Object> asignarCama(@RequestParam(value="idCama") final Long idCama, @RequestParam(value="idPaciente") final Long idPaciente){
		final Cama cama = CamaServ.readById(idCama);
		final Registro reg = new Registro();
		if(cama == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		//aca deberiamos llamar a la id del otro paciente, pero es la api de otro grupo
		if(cama.getOcupado()){
			return new ResponseEntity<>(cama,HttpStatus.CONFLICT);
		}
		CamaServ.update(cama);

		reg.setComentario("gj");
		reg.setIdpaciente(idPaciente);
		reg.setIdpabellon(cama.getIdpabellon());
		RegistroServ.create(reg);

		return new ResponseEntity<>(cama,HttpStatus.OK);
	}

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
