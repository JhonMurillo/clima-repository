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
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "barrio", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "codigo", name = "uk_codigo_barrio"))
@ApiModel("Model Barrio")
public class Barrio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "codigo", required = true)
    private String codigo;
    @Column(nullable = false)
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @Column(nullable = false)
    @ApiModelProperty(value = "estado", required = true)
    private String estado;
    @JoinColumn(nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ciudad"))
    @ManyToOne(optional = false, targetEntity = Ciudad.class)
    @ApiModelProperty(value = "id_ciudad", required = true)
    private Long idCiudad;

    public Barrio(Long id, String codigo, String nombre, String estado, Long idCiudad) {
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

    public Long id() {
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
        return new Ciudad(idCiudad);
    }

    public Ciudad getIdCiudad() {
        return new Ciudad(idCiudad);
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

}
