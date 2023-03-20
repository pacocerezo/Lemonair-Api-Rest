package dev.cerezo.lemonair.services.avion;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.cerezo.lemonair.dto.AvionDto;
import dev.cerezo.lemonair.model.Avion;
import dev.cerezo.lemonair.repository.AvionesRepository;

@ExtendWith(MockitoExtension.class)
class AvionServiceTest {

	@Mock 
	private AvionesRepository avionesRepository;
	
	@InjectMocks
	private AvionService underTest;
	
	AvionDto mockAvionDto = new AvionDto(5L, "747", 400);
	Avion mockAvion = new Avion("757", 350);
	
	ArrayList<Long> mockIdsList = new ArrayList<>(List.of(5L,6L,7L));

	ArrayList<Avion> mockAvionList = new ArrayList<>(List.of(mockAvion));

	@Test
	@Disabled
	void testFindByDespegado(boolean estado) {
		Mockito.when(avionesRepository.findAllById(mockIdsList)).thenReturn(mockAvionList);
		// when 
		underTest.findByDespegado(false);
		// then
		verify(avionesRepository).findAllById(mockIdsList);
	}

}
