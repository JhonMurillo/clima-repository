/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.pais;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "pais")
@ApiModel("Model Pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "codigo", required = true)
    private String codigo;
    @Column(nullable = false)
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @Column(nullable = false)
    @ApiModelProperty(value = "estado", required = true)
    private String estado;

    public Pais() {
    }

    public Pais(Integer id, String codigo, String nombre, String estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pais{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + '}';
    }

    public Integer id() {
        return id;
    }

    public String codigo() {
        return codigo;
    }

    public String nombre() {
        return nombre;
    }

    public String estado() {
        return estado;
    }
}
