package dev.cerezo.lemonair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cerezo.lemonair.model.Vuelo;

public interface VuelosRepository extends JpaRepository<Vuelo, Long>{
	List<Vuelo> findByDespegado(boolean despegado);
}
