package dev.cerezo.lemonair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cerezo.lemonair.dto.AerolineaDto;
import dev.cerezo.lemonair.exceptions.DatosAeropuertoNotFoundException;
import dev.cerezo.lemonair.services.aerolinea.IAerolineaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/lemonair")
public class AerolineaController {

	@Autowired
	IAerolineaService aerolineaService;

	@GetMapping("/info")
	@Operation(
			tags = {"Aerolínea Index"},
			summary = "Devolverá la información de la aerolínea",
			description = "Identificador, nombre y número de aviones en la flota"
	)
	public ResponseEntity<AerolineaDto> getAerolinea() {

		try {
			AerolineaDto datos = aerolineaService.obtenerDatosAerolinea();
			return ResponseEntity.ok(datos);
		} catch (DatosAeropuertoNotFoundException e) {
			return ResponseEntity.internalServerError().build();
		}

	}
}
