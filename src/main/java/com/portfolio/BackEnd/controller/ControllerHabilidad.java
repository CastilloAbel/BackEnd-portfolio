
package com.portfolio.BackEnd.controller;


import com.portfolio.BackEnd.model.Habilidad;
import com.portfolio.BackEnd.service.HabilidadService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class ControllerHabilidad {

    @Autowired
    HabilidadService habser;

    @GetMapping("/traer")
    public List<Habilidad> getHabilidad(){
        return habser.list();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createHabilidad(@RequestBody Habilidad hab){
        habser.save(hab);
        return "La habilidad fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteHabilidad(@PathVariable int id){
        habser.delete(id);
        return "La Habilidad fue eliminada corredctamente";
    }
    
    
  
}