
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Habilidad;
import com.portfolio.BackEnd.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService{

    @Autowired
    public HabilidadRepository habrepo;
    
    @Override
    public List<Habilidad> verHabilidades() {
        return habrepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habrepo.save(hab);
    }

    @Override
    public void eliminarHabilidad(Long id) {
        habrepo.deleteById(id);
    }

    @Override
    public Habilidad buscarHabilidad(Long id) {
        return habrepo.findById(id).orElse(null);
    }
    
}
