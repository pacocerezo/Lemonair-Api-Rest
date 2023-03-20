package dev.cerezo.lemonair.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import dev.cerezo.lemonair.model.Vuelo;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(Include.NON_NULL)
@Schema(description = "Datos del vuelo")
public class VueloDto implements Serializable {

	private static final long serialVersionUID = -4236417217837178907L;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(description = "id")
	private Long id;

	@Schema(description = "despegado")
	private boolean despegado;

	@Schema(description = "fechaDespegue")
	private Instant fechaDespegue;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Schema(description = "ultimaModificacion")
	private Instant ultimaModificacion;

	@Schema(description = "avionId")
	private Long avionId;


	public VueloDto() {
		super();
	}

	public VueloDto(Long id, boolean despegado, Instant fechaDespegue, Instant ultimaModificacion, Long avionId) {
		super();
		this.id = id;
		this.despegado = despegado;
		this.fechaDespegue = fechaDespegue;
		this.ultimaModificacion = ultimaModificacion;
		this.avionId = avionId;
	}

	public VueloDto(Vuelo vuelo) {
		super();
		this.id = vuelo.getId();
		this.despegado = vuelo.isDespegado();
		this.fechaDespegue = vuelo.getFechaDespegue();
		this.ultimaModificacion = vuelo.getUltimaModificacion();
		this.avionId = vuelo.getAvionId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDespegado() {
		return despegado;
	}

	public void setDespegado(boolean despegado) {
		this.despegado = despegado;
	}

	public Instant getFechaDespegue() {
		return fechaDespegue;
	}

	public void setFechaDespegue(Instant fechaDespegue) {
		this.fechaDespegue = fechaDespegue;
	}

	public Instant getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Instant ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	public Long getAvionId() {
		return avionId;
	}

	public void setAvionId(Long avionId) {
		this.avionId = avionId;
	}

}
