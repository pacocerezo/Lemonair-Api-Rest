package dev.cerezo.lemonair.model;

import javax.persistence.*;

@Entity
@Table(name = "aerolinea")
public class Aerolinea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "suma_aviones")
	private Integer sumaAviones;
	
	public Aerolinea () {}

	public Aerolinea(String nombre, Integer sumaAviones) {
		this.nombre = nombre;
		this.sumaAviones = sumaAviones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getSumaAviones() {
		return sumaAviones;
	}

	public void setSumaAviones(Integer sumaAviones) {
		this.sumaAviones = sumaAviones;
	}
	
	
}
