
package com.portfolio.BackEnd.controller;


import com.portfolio.BackEnd.Dto.dtoProyecto;
import com.portfolio.BackEnd.Security.Controller.Mensaje;
import com.portfolio.BackEnd.model.Proyecto;
import com.portfolio.BackEnd.service.ProyectoService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "https://portfolio-castilloabel.web.app")
public class ControllerProyecto {
    
    @Autowired
    private ProyectoService proser;
    
    @GetMapping("/traer")
    public List<Proyecto> getProyecto(){
        return proser.list();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createProyecto(@RequestBody Proyecto proyecto){
        proser.save(proyecto);
        return "El proyecto fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String deleteProyecto(@PathVariable int id){
        proser.delete(id);
        return "El proyecto fue eliminado corredctamente";
    }
    
    
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
    
        List<Proyecto> list = proser.list();
                return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!proser.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto pro = proser.getOne(id).get();
        return new ResponseEntity(pro, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proser.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proser.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro){      
        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proser.existsByNombre(dtopro.getNombre()))
            return new ResponseEntity(new Mensaje("Ese proyecto no existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto pro = new Proyecto(dtopro.getNombre(), dtopro.getLink(), dtopro.getImg(), dtopro.getDescripcion());
        proser.save(pro);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro){
        //Validamos si existe el ID
        if(!proser.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if(StringUtils.isBlank(dtopro.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto pro = proser.getOne(id).get();
        pro.setNombre(dtopro.getNombre());
        pro.setDescripcion((dtopro.getDescripcion()));
        pro.setImg((dtopro.getImg()));
        pro.setLink((dtopro.getLink()));

        
        proser.save(pro);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }

}
