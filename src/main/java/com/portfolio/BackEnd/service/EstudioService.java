
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Estudio;
import com.portfolio.BackEnd.repository.EstudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudioService implements IEstudioService{
    
    @Autowired
    public EstudioRepository estrepo;

    @Override
    public List<Estudio> verEstudios() {
        return estrepo.findAll();
    }

    @Override
    public void crearEstudio(Estudio est) {
        estrepo.save(est);
    }

    @Override
    public void eliminarEstudio(Long id) {
        estrepo.deleteById(id);
    }

    @Override
    public Estudio buscarEstudio(Long id) {
        return estrepo.findById(id).orElse(null);
    }
    
}
