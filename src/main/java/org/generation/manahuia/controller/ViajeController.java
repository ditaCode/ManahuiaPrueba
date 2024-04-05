package org.generation.manahuia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.manahuia.model.Viaje;
import com.generation.manahuia.service.ViajeService;


@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500","https://lizeth9797.github.io/manahuia/"})
//@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/viajes/")  //http://localhost:8080/api/viajes/

public class ViajeController {
	private final ViajeService viajeService;
	@Autowired
	public ViajeController(ViajeService viajeService ) {
		this.viajeService=viajeService;
	}//constructor
	
	
	//GET all
	@GetMapping
	public List<Viaje> getViajes(){
		return viajeService.getAllViajes();
	}
	
	//Get by ID
	@GetMapping (path= "{viajeId}")
	public Viaje getViaje(@PathVariable("viajeId") Long id) {
		return viajeService.getViaje(id);
	}
	
	//POST 
	@PostMapping
	public Viaje addViaje(@RequestBody Viaje viaje) {
		return viajeService.addViaje(viaje);
	}
	
	//DELETE
	@DeleteMapping(path="{viajeId}")
	public Viaje deleteViaje(@PathVariable("viajeId") Long viajeId) { 
		return viajeService.deleteViaje(viajeId);
	}

	//PUT
	@PutMapping(path="{viajeId}")
	public Viaje updateViaje(@PathVariable("viajeId") Long viajeId,
			@RequestBody Viaje viaje) {
		return viajeService.updateViaje(viajeId, viaje.getNombreDestino(), viaje.getFechaInicio(), viaje.getFechaFinal(),viaje.getDuracionDias(),viaje.getIncluye(), viaje.getDescripcion(), Double.valueOf(viaje.getPrecio()), viaje.getImagenes(), viaje.getStock()); 
	}
}


