/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.BackEnd.Dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Abel
 */
public class dtoPersona {
    @NotBlank
    @Column
    private String nombre;
            
    @NotBlank
    @Column
    private String apellido;
    
    @NotBlank
    @Column(columnDefinition = "varchar(4096)")
    private String descripcion;
    @NotBlank
    @Column
    private String puesto;
    @NotBlank
    @Column
    private String img;
    @NotBlank
    @Column
    private String mail;
    @NotBlank
    @Column
    private String telefono;
    @NotBlank
    @Column
    private String linkedin;
    @NotBlank
    @Column
    private String github;
    @NotBlank
    @Column
    private String ubicacion;
    
    
    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String descripcion, String puesto, String img, String mail, String telefono, String linkedin, String github, String ubicacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.puesto = puesto;
        this.img = img;
        this.mail = mail;
        this.telefono = telefono;
        this.linkedin = linkedin;
        this.github = github;
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

  

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
