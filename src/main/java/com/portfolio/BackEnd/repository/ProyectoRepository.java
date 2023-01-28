
package com.portfolio.BackEnd.repository;

import com.portfolio.BackEnd.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    
    public Optional<Proyecto> findByNombre(String nombreE);

    public boolean existsByNombre(String nombreE);
}
