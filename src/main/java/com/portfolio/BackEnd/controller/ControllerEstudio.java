
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.Dto.dtoEstudio;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import com.portfolio.BackEnd.model.Estudio;
import com.portfolio.BackEnd.service.EstudioService;
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
@RequestMapping("/estudio")
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerEstudio {
    @Autowired
    EstudioService sEducacion;
    
    @GetMapping("/traer")
    public List<Estudio> getEstudio(){
        return sEducacion.list();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createEstudio(@RequestBody Estudio estudio){
        sEducacion.save(estudio);
        return "El estudio fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteEstudio(@PathVariable int id){
        sEducacion.delete(id);
        return "El estudio fue eliminado corredctamente";
    }
    
   
}
