package dev.cerezo.lemonair.services.vuelo;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.cerezo.lemonair.dto.EstatusDespegueDto;
import dev.cerezo.lemonair.dto.VueloDto;
import dev.cerezo.lemonair.exceptions.VueloNotFoundException;
import dev.cerezo.lemonair.model.Vuelo;
import dev.cerezo.lemonair.repository.VuelosRepository;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class VueloService implements Serializable, IVueloService {

	private static final long serialVersionUID = 3561453877236716644L;
	@Autowired
	VuelosRepository vuelosRepository;

	@Override
	public List<VueloDto> findByDespegado(boolean estado) {
		return vuelosRepository.findByDespegado(estado).stream().map(v -> new VueloDto(v.getId(), v.isDespegado(),
				v.getFechaDespegue(), v.getUltimaModificacion(), v.getAvionId())).collect(Collectors.toList());
	}

	@Override
	public VueloDto createVuelo(VueloDto vuelo) {
		Vuelo v = new Vuelo(vuelo);
		this.vuelosRepository.saveAndFlush(v);
		return vuelo;
	}

	@Override
	public VueloDto getVueloById(long id) {
		if (id <= 0L) {
			throw new IllegalArgumentException();
		}
		Vuelo vueloData = vuelosRepository.findById(id).orElseThrow(() -> new VueloNotFoundException(null));
		return new VueloDto(vueloData);
	}

	@Override
	public VueloDto updateVuelo(long id, VueloDto vueloDto) {
		Vuelo vuelo = vuelosRepository.findById(id)
				.orElseThrow(() -> new VueloNotFoundException("No se ha encontrado el vuelo"));
		vuelo.setAvionId(vueloDto.getAvionId());
		vuelo.setDespegado(vueloDto.isDespegado());
		vuelo.setFechaDespegue(vueloDto.getFechaDespegue());
		return new VueloDto(vuelosRepository.saveAndFlush(vuelo));
	}

	@Override
	public void deleteVuelo(long id, VueloDto vuelo) {
		vuelosRepository.deleteById(id);
	}

	@Override
	public EstatusDespegueDto getDespegadoStatusById(long id) {
		Vuelo vueloData = vuelosRepository.findById(id)
				.orElseThrow(() -> new VueloNotFoundException("No se ha encontrado el vuelo"));
		return new EstatusDespegueDto(vueloData.isDespegado(), vueloData.getFechaDespegue());
	}

	@Override
	public VueloDto updateVueloStatus(long id) {
		Vuelo vuelo = vuelosRepository.findById(id)
				.orElseThrow(() -> new VueloNotFoundException("No se ha encontrado el vuelo"));

		vuelo.setDespegado(true);
		vuelo.setFechaDespegue(Instant.now());
		vuelo.setUltimaModificacion(Instant.now());

		return new VueloDto(vuelosRepository.saveAndFlush(vuelo));

	}

}
