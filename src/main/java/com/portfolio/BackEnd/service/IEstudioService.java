
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Estudio;
import java.util.List;

        
public interface IEstudioService {
    
    
    public List<Estudio> verEstudios();

    public void crearEstudio(Estudio est);
            
    public void eliminarEstudio(Long id);

    public Estudio buscarEstudio(Long id);
}
