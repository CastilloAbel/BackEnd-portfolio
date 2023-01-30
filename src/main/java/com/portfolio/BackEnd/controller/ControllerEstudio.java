
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
    
       @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
    
        List<Estudio> list = sEducacion.list();
                return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Estudio est = sEducacion.getOne(id).get();
        return new ResponseEntity(est, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Estudio eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudio dtoest){      
        if(StringUtils.isBlank(dtoest.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sEducacion.existsByNombreE(dtoest.getNombreE()))
            return new ResponseEntity(new Mensaje("Ese Estudio ya existe"), HttpStatus.BAD_REQUEST);
        
        Estudio est = new Estudio(dtoest.getNombreE(), dtoest.getDescripcionE(), dtoest.getInstitucion(), dtoest.getFechaDesde(), dtoest.getFechaHasta());
        sEducacion.save(est);
        
        return new ResponseEntity(new Mensaje("Estudio agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEstudio dtoest){
        //Validamos si existe el ID
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtoest.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Estudio est = sEducacion.getOne(id).get();
        est.setNombreE(dtoest.getNombreE());
        est.setDescripcionE((dtoest.getDescripcionE()));
        est.setInstitucion((dtoest.getInstitucion()));
        est.setFechaDesde((dtoest.getFechaDesde()));
        est.setFechaHasta((dtoest.getFechaHasta()));
        
        sEducacion.save(est);
        return new ResponseEntity(new Mensaje("Estudio actualizado"), HttpStatus.OK);
             
    }
}
