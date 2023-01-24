
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Persona;
import com.portfolio.BackEnd.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public PersonaRepository persrepo;

    @Override
    public List<Persona> verPersonas() {
        return persrepo.findAll();
    }

    @Override
    public void crearPersona(Persona per) {
        persrepo.save(per);
    }

    @Override
    public void eliminarPersona(Long id) {
        persrepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persrepo.findById(id).orElse(null);
    }
    
}
