package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Habilidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {

    Optional<Habilidad> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
