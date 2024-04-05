package com.generation.manahuia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="pedidos") 
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String fechaCreacion;
	@Column(nullable=false)
	private Long cantidadPersonas;
	@Column(nullable=false)
	private double totalPedido;
	@Column(nullable=false)
	private Long idViaje;
	@Column(nullable=false)
	private Long idUsuario;
	
	public Pedido(String fechaCreacion, Long cantidadPersonas, double totalPedido, Long idViaje, Long idUsuario) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.cantidadPersonas = cantidadPersonas;
		this.totalPedido = totalPedido;
		this.idViaje = idViaje;
		this.idUsuario = idUsuario;
	}
	
	public Pedido() {}
	
	public Long getId() {
		return id;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Long cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}

	public Long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Long idViaje) {
		this.idViaje = idViaje;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaCreacion=" + fechaCreacion + ", cantidadPersonas=" + cantidadPersonas
				+ ", totalPedido=" + totalPedido + ", idViaje=" + idViaje + ", idUsuario=" + idUsuario + "]";
	}
}