
package com.portfolio.BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    public String dni;
    public String nombre;
    public String apellido;
    public String telefono;
    public String mail;
    public String ubicacion;
    public String linkedin;
    public String github;
    public String sobreMi;

    public Persona() {
    }

    public Persona(Long id, String dni, String nombre, String apellido, String telefono, String mail, String ubicacion, String linkedin, String github, String sobreMi) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mail = mail;
        this.ubicacion = ubicacion;
        this.linkedin = linkedin;
        this.github = github;
        this.sobreMi = sobreMi;
    }
    
    
}
