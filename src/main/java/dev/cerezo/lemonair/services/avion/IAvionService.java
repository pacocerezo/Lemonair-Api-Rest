package dev.cerezo.lemonair.services.avion;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.cerezo.lemonair.dto.AvionDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public interface IAvionService {

	public List<AvionDto> findByDespegado(boolean despegado);
	

	
	
}
