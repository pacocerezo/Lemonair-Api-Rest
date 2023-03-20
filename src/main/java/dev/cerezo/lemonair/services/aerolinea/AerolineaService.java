package dev.cerezo.lemonair.services.aerolinea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.cerezo.lemonair.dto.AerolineaDto;
import dev.cerezo.lemonair.exceptions.DatosAeropuertoNotFoundException;
import dev.cerezo.lemonair.repository.AerolineasRepository;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AerolineaService implements IAerolineaService {

	@Autowired
	AerolineasRepository aerolineaRepository;

	@Override
	public AerolineaDto obtenerDatosAerolinea() {
		return aerolineaRepository.findAll().stream().findFirst()
				.map(a -> new AerolineaDto(a.getId(), a.getNombre(), a.getSumaAviones()))
				.orElseThrow(() -> new DatosAeropuertoNotFoundException("No se han encontrado datos de la aerolinea"));
	}

}
