
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Proyecto;
import com.portfolio.BackEnd.repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService{

    @Autowired
    public ProyectoRepository proyrepo;
    
public List<Proyecto> list() {
        return proyrepo.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return proyrepo.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombreE) {
        return proyrepo.findByNombre(nombreE);
    }

    public void save(Proyecto proy) {
        proyrepo.save(proy);
    }

    public void delete(int id) {
        proyrepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyrepo.existsById(id);
    }

    public boolean existsByNombre(String nombreE) {
        return proyrepo.existsByNombre(nombreE);
    }
    
    
}
