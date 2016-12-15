/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.barrio;

import com.app.demo.domains.ciudad.Ciudad;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "barrio")
@ApiModel("Model Barrio")
public class Barrio implements Serializable {

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
    @JoinColumn(referencedColumnName = "id", foreignKey = @ForeignKey)
    @ManyToOne(optional = false)
    @ApiModelProperty(value = "id_ciudad", required = true)
    private Ciudad idCiudad;

    public Barrio(Integer id, String codigo, String nombre, String estado, Ciudad idCiudad) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idCiudad = idCiudad;
    }

    public Barrio() {
    }

    @Override
    public String toString() {
        return "Barrio{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idCiudad=" + idCiudad + '}';
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

    public Ciudad idCiudad() {
        return idCiudad;
    }

}
