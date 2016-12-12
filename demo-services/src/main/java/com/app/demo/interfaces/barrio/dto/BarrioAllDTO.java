/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;

/**
 *
 * @author DESARROLLO
 */
@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "BarrioAllDTO.findInfoAll", procedureName = "procedimiento", resultClasses = BarrioAllDTO.class),})
public class BarrioAllDTO implements Serializable {

    @Id
    private Integer id;
    private String codigo;
    private String nombre;
    private String estado;
    private Integer idCiudad;
    private String codigoCiudad;
    private String estadoCiudad;
    private String nombreCiudad;
    private Integer idDepartamento;
    private String codigoDepartamento;
    private String estadoDepartamento;
    private String nombreDepartamento;
    private Integer idPais;
    private String codigoPais;
    private String estadoPais;
    private String nombrePais;

    public BarrioAllDTO() {
    }

    public BarrioAllDTO(Integer id, String codigo, String nombre, String estado, Integer idCiudad, String codigoCiudad, String estadoCiudad, String nombreCiudad, Integer idDepartamento, String codigoDepartamento, String estadoDepartamento, String nombreDepartamento, Integer idPais, String codigoPais, String estadoPais, String nombrePais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idCiudad = idCiudad;
        this.codigoCiudad = codigoCiudad;
        this.estadoCiudad = estadoCiudad;
        this.nombreCiudad = nombreCiudad;
        this.idDepartamento = idDepartamento;
        this.codigoDepartamento = codigoDepartamento;
        this.estadoDepartamento = estadoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.idPais = idPais;
        this.codigoPais = codigoPais;
        this.estadoPais = estadoPais;
        this.nombrePais = nombrePais;
    }

    @Override
    public String toString() {
        return "BarrioAllDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idCiudad=" + idCiudad + ", codigoCiudad=" + codigoCiudad + ", estadoCiudad=" + estadoCiudad + ", nombreCiudad=" + nombreCiudad + ", idDepartamento=" + idDepartamento + ", codigoDepartamento=" + codigoDepartamento + ", estadoDepartamento=" + estadoDepartamento + ", nombreDepartamento=" + nombreDepartamento + ", idPais=" + idPais + ", codigoPais=" + codigoPais + ", estadoPais=" + estadoPais + ", nombrePais=" + nombrePais + '}';
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

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getEstadoCiudad() {
        return estadoCiudad;
    }

    public void setEstadoCiudad(String estadoCiudad) {
        this.estadoCiudad = estadoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getEstadoDepartamento() {
        return estadoDepartamento;
    }

    public void setEstadoDepartamento(String estadoDepartamento) {
        this.estadoDepartamento = estadoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getEstadoPais() {
        return estadoPais;
    }

    public void setEstadoPais(String estadoPais) {
        this.estadoPais = estadoPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

}
