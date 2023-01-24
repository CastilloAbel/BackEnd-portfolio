
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Trabajo;
import java.util.List;


public interface ITrabajoService {
    
    
    public List<Trabajo> verTrabajos();
    
    public void crearTrabajo(Trabajo tra);
    
    public void eliminarTrabajo(Long id);
    
    public Trabajo buscarTrabajo(Long id);
    
}
