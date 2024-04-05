package com.generation.manahuia.service;
import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.generation.manahuia.dto.ChangePassword;
import com.generation.manahuia.model.Usuario;
import com.generation.manahuia.repository.UsuarioRepository;

@Service
@Component

public class UsuarioService {
	public final UsuarioRepository usuarioRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository=usuarioRepository;
	}	
	
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	
	/*public Usuario getId(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElseThrow(
				()->new IllegalArgumentException("El usuario con el id ["+usuarioId+"] no existe"));
	}*/
	
	public Usuario getUsuarioByCorreo(String email) {
		return usuarioRepository.findByCorreo(email).orElseThrow(
				()->new IllegalArgumentException("El usuario con el correo ["+email+"] no existe"));
	
	}
		
	public Long getTipoUsuario(String email) {
		Optional <Usuario> tempUsuario=usuarioRepository.findByCorreo(email);
		if(tempUsuario.isPresent()){
			return tempUsuario.get().getTipo_usuario();
		 }else{
		 		System.out.println("El usuario con el email ["+email+"]");
		 }
		return Long.valueOf(2);	
	}
	
	public Usuario addUsuario(Usuario usuario) {
		Usuario tempUsuario=null;
		if(usuarioRepository.findByCorreo(usuario.getCorreo()).isEmpty()){
			usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
			tempUsuario = usuarioRepository.save(usuario);
		 }else{
		 		System.out.println("El usuario con el email ["+usuario.getCorreo()+"]");
		 }
		return tempUsuario;	
	}
	
	public Usuario updateUsuario(Long usuarioId, ChangePassword changePassword) {
		Usuario tempUsuario=null;
		if(usuarioRepository.existsById(usuarioId)) { 
			tempUsuario=usuarioRepository.findById(usuarioId).get(); 
			//if(tempUsuario.getPassword().equals(changePassword.getPassword())) {
			if(passwordEncoder.matches(changePassword.getPassword(),tempUsuario.getPassword())) {
				//tempUsuario.setPassword(changePassword.getNpassword());
				tempUsuario.setPassword(passwordEncoder.encode(changePassword.getPassword()));
				usuarioRepository.save(tempUsuario);
			}else {
				System.out.println("El password del usuario con ID["+
						tempUsuario.getId()+"] no coincide");
				tempUsuario=null;
			}
		}//if existsById
		return tempUsuario;
	}

	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> userByEmail=usuarioRepository.findByCorreo(usuario.getCorreo());
		if(userByEmail.isPresent()) {
			Usuario tmpUser=userByEmail.get();
			//if(user.getPassword().equals(tmpUser.getPassword())) {
			if(passwordEncoder.matches(usuario.getPassword(), tmpUser.getPassword())) {
				return true;
			}//if equals
		}//if isPresent
		return false;
	}//validateUser

}
