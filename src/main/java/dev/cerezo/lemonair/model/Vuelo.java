package dev.cerezo.lemonair.model;

import java.time.Instant;

import javax.persistence.*;

import dev.cerezo.lemonair.dto.VueloDto;

@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "despegado")
	private boolean despegado;
	
	@Column(name = "fecha_despegue")
	private Instant fechaDespegue;

	@Column(name = "ultima_modificacion")
	private Instant ultimaModificacion;

	@Column(name = "avion_id")
	private Long avionId;

	public Vuelo() {

	}

	public Vuelo(VueloDto vueloDto) {
		this.despegado = vueloDto.isDespegado();
		this.fechaDespegue = vueloDto.getFechaDespegue();
		this.ultimaModificacion = Instant.now();
		this.avionId = vueloDto.getAvionId();
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

	@Override
	public String toString() {
		return "Vuelos [id=" + id + ", despegado=" + despegado + ", fechaDespegue=" + fechaDespegue
				+ ", ultimaModificacion=" + ultimaModificacion + ", avionId=" + avionId + "]";
	}

}
