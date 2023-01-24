
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> verPersonas();

    public void crearPersona(Persona per);
            
    public void eliminarPersona(Long id);

    public Persona buscarPersona(Long id);
}
