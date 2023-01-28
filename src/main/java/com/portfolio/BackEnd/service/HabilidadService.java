
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Habilidad;
import com.portfolio.BackEnd.repository.HabilidadRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HabilidadService{

    @Autowired
    public HabilidadRepository habrepo;
    
    public List<Habilidad> list(){
        return habrepo.findAll();
    }
    
    public Optional<Habilidad> getOne(int id){
        return habrepo.findById(id);
    }
    
    public Optional<Habilidad> getByNombre(String nombre){
        return habrepo.findByNombre(nombre);
    }
    
    public void save(Habilidad skill){
        habrepo.save(skill);
    }
    
    public void delete(int id){
        habrepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habrepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return habrepo.existsByNombre(nombre);
    }
}
