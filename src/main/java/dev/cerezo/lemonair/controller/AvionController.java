package dev.cerezo.lemonair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cerezo.lemonair.dto.AvionDto;
import dev.cerezo.lemonair.exceptions.AvionesNotFoundException;
import dev.cerezo.lemonair.services.avion.IAvionService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/lemonair")
public class AvionController {
	
	@Autowired
	IAvionService avionService;
	
	@GetMapping("/salida")
	@Operation(
			tags = {"Aviones Despegados"},
			summary = "Devolverá una lista con los aviones que han salido ya del aeropuerto",
			description = "Identificador, modelo y capacidad de pasajeros"
			
	)
	public ResponseEntity<List<AvionDto>> findByDespegado() {
		try {
			return ResponseEntity.ok(avionService.findByDespegado(true));
			
		} 
		catch (AvionesNotFoundException e) {
			return ResponseEntity.ok(List.of());
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
	}
}
