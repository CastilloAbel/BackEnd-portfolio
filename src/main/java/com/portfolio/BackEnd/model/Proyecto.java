
package com.portfolio.BackEnd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String link;
    private String img;
    private String descripcion;
    

    public Proyecto() {
    }

    public Proyecto(Long id, String nombre, String link, String img, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.img = img;
        this.descripcion = descripcion;
    }

    

    
    
    
}
