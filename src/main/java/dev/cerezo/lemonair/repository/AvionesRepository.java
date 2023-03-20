package dev.cerezo.lemonair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cerezo.lemonair.model.Avion;

public interface AvionesRepository extends JpaRepository<Avion, Long>{
}
