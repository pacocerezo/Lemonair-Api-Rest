package dev.cerezo.lemonair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cerezo.lemonair.model.Aerolinea;

public interface AerolineasRepository extends JpaRepository<Aerolinea, Long>{
	
}
