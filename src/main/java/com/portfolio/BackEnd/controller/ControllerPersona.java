
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.Dto.dtoPersona;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import com.portfolio.BackEnd.model.Persona;
import com.portfolio.BackEnd.service.PersonaService;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/personas")
@CrossOrigin(origins = "https://portfolio-castilloabel.web.app")
public class ControllerPersona {
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return personaService.list();
    }
    @GetMapping("/traer/perfil")
    public Optional<Persona> findPersona(){
        return personaService.getOne((int) 1);
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.save(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        personaService.delete(id);
        return "La persona fue eliminada corredctamente";
    }
    
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona per = personaService.getOne(id).get();
        return new ResponseEntity(per, HttpStatus.OK);
    }
       @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtoper){
        //Validamos si existe el ID
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoper.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona per = personaService.getOne(id).get();
        per.setNombre(dtoper.getNombre());
        per.setApellido((dtoper.getApellido()));
        per.setDescripcion((dtoper.getDescripcion()));
        per.setPuesto((dtoper.getPuesto()));
        per.setImg((dtoper.getImg()));
        per.setMail((dtoper.getMail()));
        per.setTelefono((dtoper.getTelefono()));
        per.setLinkedin((dtoper.getLinkedin()));
        per.setGithub((dtoper.getGithub()));
        per.setUbicacion((dtoper.getUbicacion()));

        
        personaService.save(per);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
}
