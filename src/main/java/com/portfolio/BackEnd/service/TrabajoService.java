package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Trabajo;
import com.portfolio.BackEnd.repository.TrabajoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TrabajoService{

    @Autowired
    public TrabajoRepository trabrepo;

    public List<Trabajo> list() {
        return trabrepo.findAll();
    }

    public Optional<Trabajo> getOne(int id) {
        return trabrepo.findById(id);
    }

    public Optional<Trabajo> getByNombreE(String nombreE) {
        return trabrepo.findByNombreE(nombreE);
    }

    public void save(Trabajo expe) {
        trabrepo.save(expe);
    }

    public void delete(int id) {
        trabrepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return trabrepo.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {
        return trabrepo.existsByNombreE(nombreE);
    }

}
