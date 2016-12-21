/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.domains.ciudad;

import com.app.demo.domains.barrio.Barrio;
import com.app.demo.domains.departamento.Departamento;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "ciudad", schema = "public")
@ApiModel("Model Ciudad")
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "codigo", required = true)
    private String codigo;
    @Column(nullable = false)
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @Column(nullable = false)
    @ApiModelProperty(value = "estado", required = true)
    private String estado;
    @JoinColumn(referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_departamento"))
    @ApiModelProperty(value = "id_departamento", required = true)
    @ManyToOne(optional = false)
    private Departamento idDepartamento;
    @OneToMany(mappedBy = "idCiudad")
    private Set<Barrio> barrios;

    public Ciudad() {
    }

    public Ciudad(Long id, String codigo, String nombre, String estado, Departamento idDepartamento) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idDepartamento = idDepartamento;
    }

    public Ciudad(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idDepartamento=" + idDepartamento + '}';
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

    public Departamento idDepartamento() {
        return idDepartamento;
    }

}
