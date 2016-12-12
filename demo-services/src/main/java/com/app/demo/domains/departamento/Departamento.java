/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.departamento;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "departamento")
@ApiModel("Model Departamento")
public class Departamento implements Serializable {

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
    @Column(nullable = false)
    @ApiModelProperty(value = "id_pais", required = true)
    private Integer idPais;

    public Departamento() {
    }

    public Departamento(Integer id, String codigo, String nombre, String estado, Integer idPais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idPais = idPais;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idPais=" + idPais + '}';
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

    public Integer idPais() {
        return idPais;
    }

}
