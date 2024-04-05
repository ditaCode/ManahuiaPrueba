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

import com.generation.manahuia.dto.ChangePassword;
import com.generation.manahuia.model.Usuario;
import com.generation.manahuia.service.UsuarioService;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500","https://lizeth9797.github.io/manahuia/"})
//@CrossOrigin(origins="*")
@RestController
@RequestMapping(path="/api/usuarios/") //http://localhost:8080/api/usuario/

public class UsuarioController {
	private final UsuarioService usuarioService;
	@Autowired
	public UsuarioController(UsuarioService usuarioService ) {
		this.usuarioService=usuarioService;
	}//constructor
	
	//GET all
	@GetMapping
	public List<Usuario> getUsuarios(){
		return usuarioService.getAllUsuarios();
	}
	
	//Get by ID
	/*@GetMapping (path= "{usuarioId}")
	public Usuario getId(@PathVariable("usuarioId") Long usuarioId) {
		return usuarioService.getId(usuarioId);
	}*/
	
	//Get by Correo
	@GetMapping (path= "{email}")
	public Usuario getUsuarioByCorreo(@PathVariable("email") String email) {
		return usuarioService.getUsuarioByCorreo(email);
	}
	
	
	//POST 
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	}
	
	//PUT
	@PutMapping(path="{usuarioId}")
	public Usuario updateUsuario(@PathVariable("usuarioId") Long usuarioId,
			@RequestBody ChangePassword changePassword) {
		return usuarioService.updateUsuario(usuarioId, changePassword); 
	}				

}
