package dev.cerezo.lemonair.model;

import javax.persistence.*;

@Entity
@Table(name = "aviones")
public class Avion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "capacidad_pasajeros")
	private Integer capacidadPasajeros;
	
	public Avion () {}

	public Avion(String modelo, Integer capacidadPasajeros) {
		this.modelo = modelo;
		this.capacidadPasajeros = capacidadPasajeros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCapacidadPasajeros() {
		return capacidadPasajeros;
	}

	public void setCapacidadPasajeros(Integer capacidadPasajeros) {
		this.capacidadPasajeros = capacidadPasajeros;
	}
	
	

}
