package org.generation.manahuia.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.manahuia.model.Pedido;
import com.generation.manahuia.service.PedidoService;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500","https://lizeth9797.github.io/manahuia/"})
//@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/pedido/") //http://localhost:8080/api/pedido/
public class PedidoController {
	private final PedidoService pedidoService;
	@Autowired
	public PedidoController(PedidoService pedidoService ) {
		this.pedidoService=pedidoService;
	}//constructor
	
	//GET all
	@GetMapping
	public List<Pedido> getPedidos(){
		return pedidoService.getAllPedidos();
	}
	
	//GET by ID
	@GetMapping(path= "{pedidoId}")
	public Pedido getPedido(@PathVariable("pedidoId") Long id) {
		return pedidoService.getPedido(id);
	}
	
	//POST
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pedidoService.addPedido(pedido);
	}
	
	//PUT
	@PutMapping(path="{pedidoId}")
	public Pedido updatePedido(@PathVariable("pedidoId") Long pedidoId,
			@RequestBody Pedido pedido) {
		return pedidoService.updatePedido(pedidoId, pedido.getFechaCreacion(),pedido.getCantidadPersonas(),pedido.getTotalPedido(),pedido.getIdViaje(),pedido.getIdUsuario() ); 
	}

}
