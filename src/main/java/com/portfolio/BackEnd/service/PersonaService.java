
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Persona;
import com.portfolio.BackEnd.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService{
    
    @Autowired
    public PersonaRepository persrepo;

public List<Persona> list(){
         return persrepo.findAll();
     }
     
     public Optional<Persona> getOne(int id){
         return persrepo.findById(id);
     }
     
     public Optional<Persona> getByNombre(String nombre){
         return persrepo.findByNombre(nombre);
     }
     
     public void save(Persona persona){
         persrepo.save(persona);
     }
     
     public void delete(int id){
         persrepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return persrepo.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return persrepo.existsByNombre(nombre);
     }
    
}
