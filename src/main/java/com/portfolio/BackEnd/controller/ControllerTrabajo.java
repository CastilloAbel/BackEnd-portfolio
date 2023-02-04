
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
@CrossOrigin(origins = "https://portfolio-castilloabel.web.app")
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
    
    @GetMapping("/lista")
    public ResponseEntity<List<Trabajo>> list(){
    
        List<Trabajo> list = sExperiencia.list();
                return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajo> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Trabajo experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTrabajo dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByNombreE(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Trabajo experiencia = new Trabajo(dtoexp.getNombreE(), dtoexp.getDescripcionE(), dtoexp.getInstitucion(), dtoexp.getFechaDesde(), dtoexp.getFechaHasta());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTrabajo dtoexp){
        //Validamos si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
       // if(sExperiencia.existsByNombreE(dtoexp.getNombreE()) && sExperiencia.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
          //  return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Trabajo experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));
        experiencia.setInstitucion((dtoexp.getInstitucion()));
        experiencia.setFechaDesde((dtoexp.getFechaDesde()));
        experiencia.setFechaHasta((dtoexp.getFechaHasta()));
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }

}
