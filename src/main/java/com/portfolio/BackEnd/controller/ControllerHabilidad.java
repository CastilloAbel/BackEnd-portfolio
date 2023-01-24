
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Habilidad;
import com.portfolio.BackEnd.service.IHabilidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHabilidad {
    
    @Autowired
    private IHabilidadService habser;
    
    @PostMapping("/new/habilidad")
    public void agregarHabilidad(@RequestBody Habilidad hab){
        habser.crearHabilidad(hab);
    
    }
            
    @GetMapping("/see/habilidades")
    @ResponseBody
    public List<Habilidad> verHabilidades(){
        return habser.verHabilidades();
    }
    
    @DeleteMapping("/delete/habilidad/{id}")
    public void eliminarHabilidad(@PathVariable Long id){
        habser.eliminarHabilidad(id);
    }
    
}
