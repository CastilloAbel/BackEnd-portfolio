package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Trabajo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {

    public Optional<Trabajo> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);
}
