/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.departamento.dto;

import java.io.Serializable;

/**
 *
 * @author DESARROLLO
 */
public class DepartamentoDTO implements Serializable {

    private Integer id;
    private String codigo;
    private String nombre;
    private String estado;
    private Integer idPais;

    public DepartamentoDTO(Integer id, String codigo, String nombre, String estado, Integer idPais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idPais = idPais;
    }

    public DepartamentoDTO() {
    }

    @Override
    public String toString() {
        return "DepartamentoDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idPais=" + idPais + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

}
