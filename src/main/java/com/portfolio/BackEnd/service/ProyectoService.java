
package com.portfolio.BackEnd.service;

import com.portfolio.BackEnd.model.Proyecto;
import com.portfolio.BackEnd.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyrepo;
    
    @Override
    public List<Proyecto> verProyectos() {
        return proyrepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto pro) {
        proyrepo.save(pro);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyrepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyrepo.findById(id).orElse(null);
    }
    
    
}
