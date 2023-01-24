
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Persona;
import com.portfolio.BackEnd.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerPersona {
    
    @Autowired
    private IPersonaService perser;
    
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers){
        perser.crearPersona(pers);
    }
    
    @GetMapping("/see/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return perser.verPersonas();
    }
    
    }
