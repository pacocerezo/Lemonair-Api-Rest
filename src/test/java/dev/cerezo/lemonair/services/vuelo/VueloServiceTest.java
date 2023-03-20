package dev.cerezo.lemonair.services.vuelo;

import static org.mockito.Mockito.verify;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cerezo.lemonair.dto.VueloDto;
import dev.cerezo.lemonair.model.Vuelo;
import dev.cerezo.lemonair.repository.VuelosRepository;

@ExtendWith(MockitoExtension.class)
class VueloServiceTest {

	@Mock 
	private VuelosRepository vuelosRepository;
	
	@InjectMocks
	private VueloService underTest;
	
	
	VueloDto vueloDtoNoDespegado = new VueloDto(5L, false, Instant.now(), Instant.now(), 5L);
	VueloDto vueloDtoDespegado = new VueloDto(6L, true, Instant.now(), Instant.now(), 6L);
	
	Optional<Vuelo> mockVueloNoDespegado = Optional.of(new Vuelo(vueloDtoNoDespegado));
	Vuelo mockVueloDespegado = new Vuelo(vueloDtoDespegado);
		
	ArrayList<Vuelo> esperado = new ArrayList<>(List.of(mockVueloDespegado, mockVueloDespegado));
		
	
	@Test
	void testFindByDespegado() {
		Mockito.when(vuelosRepository.findByDespegado(false)).thenReturn(esperado);
		// when
		underTest.findByDespegado(false);
		// then
		verify(vuelosRepository).findByDespegado(false);
	}

	@Test
	@Disabled
	void testCreateVuelo(VueloDto vuelo) {
		// when
		underTest.createVuelo(vueloDtoDespegado);
		// then
		verify(vuelosRepository).saveAndFlush(mockVueloDespegado);
	}
	
	@Test
	@Disabled
	void testGetVueloById(Long id) {
		Mockito.when(vuelosRepository.findById(5L)).thenReturn(mockVueloNoDespegado);
		// when 
		underTest.getVueloById(5L);
		// then
		verify(vuelosRepository).findById(5L);
	}

		
	@Test
	@Disabled
	void testUpdateVuelo(long id, VueloDto vueloDto) {
		Mockito.when(vuelosRepository.findById(5L)).thenReturn(mockVueloNoDespegado);
		// when
		underTest.updateVuelo(5L, vueloDtoNoDespegado);
		// then
		verify(vuelosRepository).findById(5L);
	}

	@Test
	@Disabled
	void testDeleteVuelo(long id, VueloDto vuelo) {
		Mockito.when(vuelosRepository.findById(5L)).thenReturn(mockVueloNoDespegado);
		// when
		underTest.deleteVuelo(5L, vueloDtoNoDespegado);
		// then
		verify(vuelosRepository).deleteById(5L);
	}


	@Test
	@Disabled
	void testGetDespegadoStatusById(long id) {
		Mockito.when(vuelosRepository.findById(5L)).thenReturn(mockVueloNoDespegado);
		// when 
		underTest.getDespegadoStatusById(5L);
		// then
		verify(vuelosRepository).findById(5L);
	}

	@Test
	@Disabled
	void testUpdateVueloStatus(long id) {
		Mockito.when(vuelosRepository.findById(5L)).thenReturn(mockVueloNoDespegado);
		// when 
		underTest.updateVueloStatus(5L);
		// then
		verify(vuelosRepository).findById(5L);
	}

}

