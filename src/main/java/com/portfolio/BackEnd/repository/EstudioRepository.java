package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Estudio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer> {

    public Optional<Estudio> findByNombreE(String nombreE);

    public boolean existsByNombreE(String nombreE);
}
