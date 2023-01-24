
package com.portfolio.BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tipoHabilidad;
    private String nombre;
    private int nivelHabilidad;

    public Habilidad() {
    }

    public Habilidad(Long id, String tipoHabilidad, String nombre, int nivelHabilidad) {
        this.id = id;
        this.tipoHabilidad = tipoHabilidad;
        this.nombre = nombre;
        this.nivelHabilidad = nivelHabilidad;
    }
    
    
    
}
