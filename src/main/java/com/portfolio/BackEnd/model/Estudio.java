
package com.portfolio.BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Estudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tipoEstudio;
    private String nombre;
    private String fecha;
    private String institucion;

    public Estudio() {
    }

    public Estudio(Long id, String tipoEstudio, String nombre, String fecha, String institucion) {
        this.id = id;
        this.tipoEstudio = tipoEstudio;
        this.nombre = nombre;
        this.fecha = fecha;
        this.institucion = institucion;
    }
    
    
    
}
