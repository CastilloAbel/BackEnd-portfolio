
package com.portfolio.BackEnd.controller;

import com.portfolio.BackEnd.model.Proyecto;
import com.portfolio.BackEnd.service.IProyectoService;
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
public class ControllerProyecto {
    
    @Autowired
    private IProyectoService proser;
    
    @PostMapping("/new/proyecto")
    public void agregarProyecto(@RequestBody Proyecto pro){
        proser.crearProyecto(pro);
}
    @GetMapping("/see/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos(){
        return proser.verProyectos();
    }
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void eliminarProyecto(@PathVariable Long id){
        proser.eliminarProyecto(id);
    }
}
