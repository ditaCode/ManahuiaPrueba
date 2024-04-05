package com.generation.manahuia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.manahuia.model.Viaje;
import com.generation.manahuia.repository.ViajeRepository;

@Service

public class ViajeService {
	public final ViajeRepository viajeRepository;
	@Autowired
	public ViajeService(ViajeRepository viajeRepository ) {
		this.viajeRepository=viajeRepository;
	}//constructor
	
	
	public List<Viaje> getAllViajes() {
		return viajeRepository.findAll();
	}


	public Viaje getViaje(Long viajeId) {
		return viajeRepository.findById(viajeId).orElseThrow(
				()->new IllegalArgumentException("El viaje con el id ["+viajeId+"] no existe"));
	}

	
	public Viaje addViaje(Viaje viaje) {
		Optional<Viaje> tempViaje=viajeRepository.findByNombreDestino(viaje.getNombreDestino());
		 if(tempViaje.isEmpty()){
		 	return viajeRepository.save(viaje);
		 }else{
		 		System.out.println("Ya existe el producto con el nombre ["+viaje.getNombreDestino()+"]");
		 		return null;
		 }
	}


	public Viaje deleteViaje(Long viajeId) {
		Viaje tempViaje=null;
		if(viajeRepository.existsById(viajeId)) { 
			tempViaje=viajeRepository.findById(viajeId).get();
			viajeRepository.deleteById(viajeId);
		}//if
		return tempViaje;	
	}


	public Viaje updateViaje(Long viajeId, String nombre_destino, String fecha_inicio, String fecha_final,
			Long duracion_dias, String incluye, String descripcion, Double precio, String imagenes, Long stock) {
		Viaje viaje=null;
			if(viajeRepository.existsById(viajeId)) {
				viaje=viajeRepository.findById(viajeId).get();
				if(nombre_destino.length()!=0) viaje.setNombreDestino(nombre_destino);
				if(fecha_inicio.length()!=0) viaje.setFechaInicio(fecha_inicio);
				if(fecha_final.length()!=0) viaje.setFechaFinal(fecha_final);
				if(duracion_dias> 0) viaje.setDuracionDias(duracion_dias);
				if(incluye.length()!=0) viaje.setIncluye(incluye);
				if(descripcion.length()!=0) viaje.setDescripcion(descripcion);
				if(precio.doubleValue()>0) viaje.setPrecio(precio);
				if(imagenes.length()!=0) viaje.setImagenes(imagenes);
				if(stock > 0) viaje.setStock(stock);
				viajeRepository.save(viaje);
			}
		return viaje;
	}

}
