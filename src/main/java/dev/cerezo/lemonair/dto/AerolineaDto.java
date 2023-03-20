package dev.cerezo.lemonair.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos de la aerolinea")
public class AerolineaDto implements Serializable {

	private static final long serialVersionUID = 6486958406218565635L;

	@Schema(description = "Id")
	private Long id;
	
	@Schema(description = "Nombre")
	private String nombre;
	
	@Schema(description = "Número total de aviones")
	private Integer sumaAviones;
	
	

	public AerolineaDto() {
	}

	public AerolineaDto(Long id, String nombre, Integer sumaAviones) {
		this.id = id;
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
