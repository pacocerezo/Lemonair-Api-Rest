package dev.cerezo.lemonair.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@Schema(description = "Datos de un error")
@NoArgsConstructor
public class ErrorDto implements Serializable {

	private static final long serialVersionUID = -2310998190404773909L;

	@Schema(description = "Nombre")
	private String descripcion;

	public ErrorDto(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
