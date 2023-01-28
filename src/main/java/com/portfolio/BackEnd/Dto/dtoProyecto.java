/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Abel
 */
public class dtoProyecto {
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private String link;
    @NotBlank
    private String nombre;

    public dtoProyecto() {
    }

    public dtoProyecto(String descripcion, String img, String link, String nombre) {
        this.descripcion = descripcion;
        this.img = img;
        this.link = link;
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
