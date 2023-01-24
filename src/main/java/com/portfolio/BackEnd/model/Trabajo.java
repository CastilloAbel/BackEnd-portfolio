
package com.portfolio.BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Trabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombreTrabajo;
    private String fechaDesde;
    private String fechaHasta;
    private String nombreEmpresa;

    public Trabajo() {
    }

    public Trabajo(Long id, String nombreTrabajo, String fechaDesde, String fechaHasta, String nombreEmpresa) {
        this.id = id;
        this.nombreTrabajo = nombreTrabajo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.nombreEmpresa = nombreEmpresa;
    }
    
    
    
}
