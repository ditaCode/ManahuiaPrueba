package com.generation.manahuia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="usuarios") 

public class Usuario {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private Long tipo_usuario;
	
	public Usuario(String nombre, String correo, String password, String telefono,
			Long tipo_usuario) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.password = password;
		this.telefono = telefono;
		this.tipo_usuario = tipo_usuario;
	}	
	
	public Usuario() {
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(Long tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password
				+ ", confirmpassword="  + ", telefono=" + telefono + ", tipo_usuario=" + tipo_usuario
				+ "]";
	}

}
