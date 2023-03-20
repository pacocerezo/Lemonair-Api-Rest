package dev.cerezo.lemonair.dto;

import java.io.Serializable;
import java.time.Instant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@Schema(description = "Estado de una salida de un vuelo")
@NoArgsConstructor
public class EstatusDespegueDto implements Serializable {

	private static final long serialVersionUID = 3104658218074673457L;

	@Schema(description = "Id")
	private boolean despegado;

	@Schema(description = "Id")
	private Instant horaDespegue;

	public EstatusDespegueDto(boolean despegado, Instant horaDespegue) {
		super();
		this.despegado = despegado;
		this.horaDespegue = horaDespegue;
	}

	public boolean isDespegado() {
		return despegado;
	}

	public void setDespegado(boolean despegado) {
		this.despegado = despegado;
	}

	public Instant getHoraDespegue() {
		return horaDespegue;
	}

	public void setHoraDespegue(Instant horaDespegue) {
		this.horaDespegue = horaDespegue;
	}

}
