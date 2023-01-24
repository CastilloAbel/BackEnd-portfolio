
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Trabajo;
import com.portfolio.BackEnd.service.ITrabajoService;
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
public class ControllerTrabajo {
    
    @Autowired
    private ITrabajoService trabser;
    
    @PostMapping("/new/trabajo")
    public void agregarTrabajo(@RequestBody Trabajo tra){
        trabser.crearTrabajo(tra);
    }
    
    @GetMapping("/see/trabajos")
    @ResponseBody
    public List<Trabajo> verTrabajos(){
        return trabser.verTrabajos();
    }
    
    
    @DeleteMapping("/delete/trabajo/{id}")
    public void eliminarTrabajo(@PathVariable Long id){
        trabser.eliminarTrabajo(id);
    }
    
}
