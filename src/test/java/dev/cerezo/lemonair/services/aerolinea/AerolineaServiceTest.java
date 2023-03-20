package dev.cerezo.lemonair.services.aerolinea;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cerezo.lemonair.model.Aerolinea;
import dev.cerezo.lemonair.repository.AerolineasRepository;

@ExtendWith(MockitoExtension.class)
class AerolineaServiceTest {

	@Mock 
	private AerolineasRepository aerolineaRepository;
	
	@InjectMocks
	private AerolineaService underTest;
	
	Aerolinea mockAerolinea = new Aerolinea("citricsair", 6);
	
	ArrayList<Aerolinea> mockList = new ArrayList<>(List.of(mockAerolinea));
	
	@Test
	void testObtenerDatosAerolinea() {
		Mockito.when(aerolineaRepository.findAll()).thenReturn(mockList);
		// when 
		underTest.obtenerDatosAerolinea();
		// then
		verify(aerolineaRepository).findAll();
	}
	
	

}
