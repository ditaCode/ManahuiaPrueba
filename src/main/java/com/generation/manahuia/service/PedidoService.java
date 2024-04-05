package com.generation.manahuia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.manahuia.model.Pedido;
import com.generation.manahuia.repository.PedidoRepository;

@Service

public class PedidoService {
	
	public final PedidoRepository pedidoRepository;
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository ) {
		this.pedidoRepository=pedidoRepository;
	}//constructor
	
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedido(Long pedidoId) {
		return pedidoRepository.findById(pedidoId).orElseThrow(
				()->new IllegalArgumentException("El pedido con el id ["+pedidoId+"] no existe"));
	}
	
	public Pedido addPedido(Pedido pedido) {
		Pedido tempPedido=null;
		tempPedido=pedidoRepository.save(pedido);
		 return tempPedido;
	}

	public Pedido updatePedido(Long pedidoId, String fechaCreacion, Long cantidadPersonas, double totalPedido,
			Long idViaje, Long idUsuario) {
		Pedido pedido=null;
		if(pedidoRepository.existsById(pedidoId)) {
			pedido=pedidoRepository.findById(pedidoId).get();
			if(fechaCreacion.length()!=0) pedido.setFechaCreacion(fechaCreacion);
			if(cantidadPersonas>0) pedido.setCantidadPersonas(cantidadPersonas);
			if(idViaje>0) pedido.setIdViaje(idViaje);
			if(idUsuario>0) pedido.setIdUsuario(idUsuario);
			pedidoRepository.save(pedido);
		}
	return pedido;
	}

}
