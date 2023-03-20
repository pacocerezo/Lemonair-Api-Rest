package dev.cerezo.lemonair.services.aerolinea;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.cerezo.lemonair.dto.AerolineaDto;

@Service
public interface IAerolineaService {

	@Transactional(readOnly = false)
	public AerolineaDto obtenerDatosAerolinea();

}
