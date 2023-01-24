
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Habilidad;
import java.util.List;


public interface IHabilidadService {
    
    
    public List<Habilidad> verHabilidades();

    public void crearHabilidad(Habilidad hab);
            
    public void eliminarHabilidad(Long id);

    public Habilidad buscarHabilidad(Long id);
}
