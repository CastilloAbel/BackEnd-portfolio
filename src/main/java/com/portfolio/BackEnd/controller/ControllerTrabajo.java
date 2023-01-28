
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.Dto.dtoTrabajo;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import com.portfolio.BackEnd.model.Trabajo;
import com.portfolio.BackEnd.service.TrabajoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trabajos")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerTrabajo {
    @Autowired
    TrabajoService sExperiencia;
    
    @GetMapping("/traer")
    public List<Trabajo> getTrabajo(){
        return sExperiencia.list();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createTrabajo(@RequestBody Trabajo trabajo){
        sExperiencia.save(trabajo);
        return "El trabajo fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteTrabajo(@PathVariable int id){
        sExperiencia.delete(id);
        return "El trabajo fue eliminado corredctamente";
    }
    
    

}
