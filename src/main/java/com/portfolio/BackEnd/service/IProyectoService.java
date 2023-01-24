
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Proyecto;
import java.util.List;


public interface IProyectoService {

    public List<Proyecto> verProyectos();
    
    public void crearProyecto(Proyecto pro);
    
    public void eliminarProyecto(Long id);
    
    public Proyecto buscarProyecto(Long id);
}
