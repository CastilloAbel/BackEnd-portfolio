
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Trabajo;
import com.portfolio.BackEnd.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService implements ITrabajoService{

    @Autowired
    public TrabajoRepository trabrepo;
    
    @Override
    public List<Trabajo> verTrabajos() {
        return trabrepo.findAll();
    }

    @Override
    public void crearTrabajo(Trabajo tra) {
        trabrepo.save(tra);
    }

    @Override
    public void eliminarTrabajo(Long id) {
        trabrepo.deleteById(id);
    }

    @Override
    public Trabajo buscarTrabajo(Long id) {
        return trabrepo.findById(id).orElse(null);
    }
    
}
