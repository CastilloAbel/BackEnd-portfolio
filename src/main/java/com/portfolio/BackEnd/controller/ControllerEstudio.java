
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Estudio;
import com.portfolio.BackEnd.service.IEstudioService;
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
public class ControllerEstudio {
    
    @Autowired
    private IEstudioService estser;
    
    @PostMapping("/new/estudio")
    public void agregarEstudio(@RequestBody Estudio est){
        estser.crearEstudio(est);
    
    }
    
    @GetMapping("/see/estudios")
    @ResponseBody
    public List<Estudio> verEstudios(){
        return estser.verEstudios();
    
    }
    
    @DeleteMapping("/delete/estudio/{id}")
    public void eliminarEstudio(@PathVariable Long id){
        estser.eliminarEstudio(id);
    }
}
