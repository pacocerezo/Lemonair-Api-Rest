package dev.cerezo.lemonair.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.cerezo.lemonair.dto.VueloDto;
import dev.cerezo.lemonair.model.Vuelo;

@DataJpaTest
class VuelosRepositoryTest {
	
	@Autowired
	private VuelosRepository underTest;
	
	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}

	@Test
	void itShouldCheckIfVueloDespegadoStatusIsFalse() {
		// given
		boolean estado = false;
		
		VueloDto vueloDto = new VueloDto(5L, estado, Instant.now(), Instant.now(), 5L);
		
		Vuelo vuelo = new Vuelo(vueloDto);
		
		underTest.save(vuelo);
		
		// when
		List<Vuelo> vuelosNoDespegados = underTest.findByDespegado(estado);
		
		List<Boolean> estadoVuelosNoDespegados = vuelosNoDespegados.stream().map(v -> v.isDespegado()).collect(Collectors.toList());
		
		// then
		assertFalse(estadoVuelosNoDespegados.get(0));
	}
	
	@Test
	void itShouldCheckIfVueloDespegadoStatusIsTrue() {
		// given
		boolean estado = true;
		
		VueloDto vueloDto = new VueloDto(5L, estado, Instant.now(), Instant.now(), 5L);
		
		Vuelo vuelo = new Vuelo(vueloDto);
		
		underTest.save(vuelo);
		
		// when
		List<Vuelo> vuelosDespegados = underTest.findByDespegado(estado);
		
		List<Boolean> estadoVuelosDespegados = vuelosDespegados.stream().map(v -> v.isDespegado()).collect(Collectors.toList());
		
		// then
		assertTrue(estadoVuelosDespegados.get(0));
	}

}
