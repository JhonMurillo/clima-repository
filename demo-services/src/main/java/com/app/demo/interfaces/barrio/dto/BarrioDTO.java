/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.dto;

import java.io.Serializable;

/**
 *
 * @author DESARROLLO
 */
public class BarrioDTO implements Serializable {

    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
    private Long idCiudad;

    public BarrioDTO(Long id, String codigo, String nombre, String estado, Long idCiudad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idCiudad = idCiudad;
    }

    public BarrioDTO() {
    }

    @Override
    public String toString() {
        return "BarrioDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idCiudad=" + idCiudad + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

}
