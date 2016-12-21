/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.ciudad.dto;

import java.io.Serializable;

/**
 *
 * @author DESARROLLO
 */
public class CiudadDTO implements Serializable {

    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
    private Long idDepartamento;

    public CiudadDTO(Long id, String codigo, String nombre, String estado, Long idDepartamento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
    }

    public CiudadDTO() {
    }

    @Override
    public String toString() {
        return "CiudadDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idDepartamento=" + idDepartamento + '}';
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

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
