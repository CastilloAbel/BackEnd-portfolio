package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Estudio;
import com.portfolio.BackEnd.repository.EstudioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EstudioService{

    @Autowired
    public EstudioRepository estrepo;

    public List<Estudio> list() {
        return estrepo.findAll();
    }

    public Optional<Estudio> getOne(int id) {
        return estrepo.findById(id);
    }

    public Optional<Estudio> getByNmbreE(String nombreE) {
        return estrepo.findByNombreE(nombreE);
    }

    public void save(Estudio educacion) {
        estrepo.save(educacion);
    }

    public void delete(int id) {
        estrepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return estrepo.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {
        return estrepo.existsByNombreE(nombreE);
    }

}
