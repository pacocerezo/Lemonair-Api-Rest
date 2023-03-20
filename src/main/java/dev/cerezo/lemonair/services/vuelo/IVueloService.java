package dev.cerezo.lemonair.services.vuelo;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.cerezo.lemonair.dto.EstatusDespegueDto;
import dev.cerezo.lemonair.dto.VueloDto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public interface IVueloService {

	public List<VueloDto> findByDespegado(boolean estado);

	public VueloDto createVuelo(VueloDto vuelo);

	public VueloDto getVueloById(long id);

	public VueloDto updateVuelo(long id, VueloDto vuelo);

	public void deleteVuelo(long id, VueloDto vuelo);

	public EstatusDespegueDto getDespegadoStatusById(long id);

	public VueloDto updateVueloStatus(long id);

}
