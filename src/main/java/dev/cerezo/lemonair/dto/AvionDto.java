package dev.cerezo.lemonair.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "flota de aviones")
public class AvionDto implements Serializable {

	private static final long serialVersionUID = -1203793410776586047L;

	@Schema(description = "Id")
	private Long id;
	
	@Schema(description = "modelo")
	private String modelo;
	
	@Schema(description = "Capacidad de pasajeros")
	private Integer capacidadPasajeros;
	
	public AvionDto () {}

	public AvionDto(Long id, String modelo, Integer capacidadPasajeros) {
		this.id = id;
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
