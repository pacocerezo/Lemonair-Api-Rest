package dev.cerezo.lemonair.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cerezo.lemonair.dto.ErrorDto;
import dev.cerezo.lemonair.dto.EstatusDespegueDto;
import dev.cerezo.lemonair.dto.VueloDto;
import dev.cerezo.lemonair.exceptions.VueloNotFoundException;
import dev.cerezo.lemonair.repository.VuelosRepository;
import dev.cerezo.lemonair.services.vuelo.IVueloService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/lemonair")
public class VueloController {

	@Autowired
	IVueloService vueloService;
	@Autowired
	VuelosRepository vuelosRepository;

	@GetMapping("/vuelo")
	@Operation(
			tags = {"Vuelos Info"},
			summary = "Obtener información de los vuelos programados",
			description = "Devolverá una lista con los vuelos pendientes de despegar del aeropuerto"
			
	)
	public ResponseEntity<List<VueloDto>> findByDespegado() {
		try {
			return ResponseEntity.ok(vueloService.findByDespegado(false));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/vuelo")
	@Operation(
			tags = {"Editar vuelos"},
			summary = "Añadir un nuevo vuelo",
			description = "Añadirá un nuevo vuelo a la lista de pendientes de despegar del aeropuerto",
					requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
							description = "Introducir Fecha de Despegue en formato UNIX (ej: 1679294143)")
	)
	public ResponseEntity<VueloDto> createVuelos(@RequestBody VueloDto vuelo) {
		try {
			VueloDto vueloDto = vueloService.createVuelo(vuelo);
			return ResponseEntity.created(URI.create("vuelos/" + vueloDto.getId())).body(vueloDto);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/vuelo/{id}")
	@Operation(
			tags = {"Vuelos Info"},
			summary = "Consultar vuelo",
			description = "Devolverá los datos del vuelo identificado por su Id"
			
	)
	public ResponseEntity<Object> getVueloById(@PathVariable("id") long id) {
		try {
			VueloDto vueloDto = vueloService.getVueloById(id);
			return ResponseEntity.ok(vueloDto);
		} catch (VueloNotFoundException e) {
			ErrorDto error = new ErrorDto("No se ha encontrado el vuelo con id: " + id);
			return ResponseEntity.ok().body(error);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/vuelo/{id}")
	@Operation(
			tags = {"Editar vuelos"},
			summary = "Editar vuelo",
			description = "Editará el vuelo identificado por su Id con los nuevos datos",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Introducir Fecha de Despegue en formato UNIX (ej: 1679294143)")
	)
	public ResponseEntity<Object> updateVuelos(@PathVariable("id") long id, @RequestBody VueloDto newVuelo) {
		try {
			VueloDto vueloDto = vueloService.updateVuelo(id, newVuelo);
			return ResponseEntity.ok(vueloDto);
		} catch (VueloNotFoundException e) {
			ErrorDto error = new ErrorDto("No se ha encontrado el vuelo a actualizar con id: " + id);
			return ResponseEntity.ok().body(error);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/vuelo/{id}")
	@Operation(
			tags = {"Editar vuelos"},
			summary = "Borrar vuelo",
			description = "Eliminará el vuelo identificado por su Id de la la lista de vuelos pendientes de despegar",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "Posibilidad solicitada por cliente pero sin implementación, incluir solo Id")
			
	)
	public ResponseEntity<HttpStatus> deleteVuelos(@PathVariable("id") long id, @RequestBody VueloDto vuelo) {
		try {
			vueloService.deleteVuelo(id, vuelo);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/salida/{id}")
	@Operation(
			tags = {"Vuelos Info"},
			summary = "Consultar estado del vuelo",
			description = "Indicará si el vuelo ha salido ya o no y la hora de dicha salida"
			
			
	)
	public ResponseEntity<Object> getDespegadoStatusById(@PathVariable("id") long id) {
		try {
			EstatusDespegueDto estatus = vueloService.getDespegadoStatusById(id);
			return ResponseEntity.ok(estatus);
		} catch (VueloNotFoundException e) {
			ErrorDto error = new ErrorDto("No se ha encontrado el vuelo con id: " + id);
			return ResponseEntity.ok().body(error);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/salida/{id}/despegue")
	@Operation(
			tags = {"Editar vuelos"},
			summary = "Vuelo ha despegado",
			description = "Editará el vuelo identificado por su Id indicando que ha salido del aeropuerto"
			
	)
	public ResponseEntity<Object> updateVueloStatus(@PathVariable("id") long id) {
		try {
			VueloDto vuelo = vueloService.updateVueloStatus(id);
			return ResponseEntity.ok(vuelo);
		} catch (VueloNotFoundException e) {
			ErrorDto error = new ErrorDto("No se ha encontrado el vuelo con id: " + id);
			return ResponseEntity.ok(error);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
