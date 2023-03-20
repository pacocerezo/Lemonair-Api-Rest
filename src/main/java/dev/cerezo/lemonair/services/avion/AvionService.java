package dev.cerezo.lemonair.services.avion;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.cerezo.lemonair.dto.AvionDto;
import dev.cerezo.lemonair.exceptions.AvionesNotFoundException;
import dev.cerezo.lemonair.model.Vuelo;
import dev.cerezo.lemonair.repository.AvionesRepository;
import dev.cerezo.lemonair.repository.VuelosRepository;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AvionService implements Serializable, IAvionService {

	private static final long serialVersionUID = 114352497841104379L;

	@Autowired
	AvionesRepository avionRepository;

	@Autowired
	VuelosRepository vuelosRepository;

	@Override
	@Transactional(readOnly = false)
	public List<AvionDto> findByDespegado(boolean estado) {
		List<Vuelo> vuelosDespegados = vuelosRepository.findByDespegado(estado);

		if (vuelosDespegados.isEmpty()) {
			throw new AvionesNotFoundException("No se han encontrado aviones con estado :" + estado);
		}

		List<Long> idsAviones = vuelosDespegados.stream().map(v -> v.getAvionId()).collect(Collectors.toList());

		return avionRepository.findAllById(idsAviones).stream()
				.map(a -> new AvionDto(a.getId(), a.getModelo(), a.getCapacidadPasajeros()))
				.collect(Collectors.toList());

	}

}
