package com.generation.manahuia.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;


@Entity
@Table(name="viajes") 
public class Viaje {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=true)
	private String nombreDestino;
	@Column(nullable=false)
	private String fechaInicio; //YYYY-MM-DD
	@Column(nullable=false)
	private String fechaFinal;  //YYYY-MM-DD
	@Column(nullable=false)
	private Long duracionDias;
	@Column(nullable=false)
	private String incluye;
	@Column(nullable=false)
	private String descripcion;
	@Column(nullable=false)
	private double precio;
	@Column(nullable=false)
	private String imagenes;
	@Column(nullable=false)
	private Long stock;
	
	public Viaje(String nombreDestino, String fechaInicio, String fechaFinal, Long duracionDias, String incluye,
			String descripcion, double precio, String imagenes, Long stock) {
		super();
		this.nombreDestino = nombreDestino;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.duracionDias = duracionDias;
		this.incluye = incluye;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagenes = imagenes;
		this.stock = stock;
	}
	
	public Viaje() {
	}

	public Long getId() {
		return id;
	}
	public String getNombreDestino() {
		return nombreDestino;
	}

	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Long getDuracionDias() {
		return duracionDias;
	}

	public void setDuracionDias(Long duracionDias) {
		this.duracionDias = duracionDias;
	}

	public String getIncluye() {
		return incluye;
	}

	public void setIncluye(String incluye) {
		this.incluye = incluye;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getImagenes() {
		return imagenes;
	}

	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Viaje [id=" + id + ", nombreDestino=" + nombreDestino + ", fechaInicio=" + fechaInicio
				+ ", fechaFinal=" + fechaFinal + ", duracionDias=" + duracionDias + ", incluye=" + incluye
				+ ", descripcion=" + descripcion + ", precio=" + precio + ", imagenes=" + imagenes + ", stock=" + stock
				+ "]";
	}
}
