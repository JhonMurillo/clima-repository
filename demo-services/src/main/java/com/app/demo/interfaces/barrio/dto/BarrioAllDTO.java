/*
 * To change this license header; choose License Headers in project properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.dto;

import java.io.Serializable;

/**
 *
 * @author dESARROLLO
 */
public class BarrioAllDTO implements Serializable {

    private Long id;
    private String codigo;
    private String nombre;
    private String estado;
    private Long idciudad;
    private String codigociudad;
    private String estadociudad;
    private String nombreciudad;
    private Long iddepartamento;
    private String codigodepartamento;
    private String estadodepartamento;
    private String nombredepartamento;
    private Long idpais;
    private String codigopais;
    private String estadopais;
    private String nombrepais;

    public BarrioAllDTO() {
    }

    public BarrioAllDTO(Long id, String codigo, String nombre, String estado, Long idciudad, String codigociudad, String estadociudad, String nombreciudad, Long iddepartamento, String codigodepartamento, String estadodepartamento, String nombredepartamento, Long idpais, String codigopais, String estadopais, String nombrepais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.idciudad = idciudad;
        this.codigociudad = codigociudad;
        this.estadociudad = estadociudad;
        this.nombreciudad = nombreciudad;
        this.iddepartamento = iddepartamento;
        this.codigodepartamento = codigodepartamento;
        this.estadodepartamento = estadodepartamento;
        this.nombredepartamento = nombredepartamento;
        this.idpais = idpais;
        this.codigopais = codigopais;
        this.estadopais = estadopais;
        this.nombrepais = nombrepais;
    }

    @Override
    public String toString() {
        return "BarrioAllDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado + ", idciudad=" + idciudad + ", codigociudad=" + codigociudad + ", estadociudad=" + estadociudad + ", nombreciudad=" + nombreciudad + ", iddepartamento=" + iddepartamento + ", codigodepartamento=" + codigodepartamento + ", estadodepartamento=" + estadodepartamento + ", nombredepartamento=" + nombredepartamento + ", idpais=" + idpais + ", codigopais=" + codigopais + ", estadopais=" + estadopais + ", nombrepais=" + nombrepais + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcodigo() {
        return codigo;
    }

    public void setcodigo(String codigo) {
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

    public Long getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    public String getcodigociudad() {
        return codigociudad;
    }

    public void setcodigociudad(String codigociudad) {
        this.codigociudad = codigociudad;
    }

    public String getEstadociudad() {
        return estadociudad;
    }

    public void setEstadociudad(String estadociudad) {
        this.estadociudad = estadociudad;
    }

    public String getNombreciudad() {
        return nombreciudad;
    }

    public void setNombreciudad(String nombreciudad) {
        this.nombreciudad = nombreciudad;
    }

    public Long getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Long iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getcodigodepartamento() {
        return codigodepartamento;
    }

    public void setcodigodepartamento(String codigodepartamento) {
        this.codigodepartamento = codigodepartamento;
    }

    public String getEstadodepartamento() {
        return estadodepartamento;
    }

    public void setEstadodepartamento(String estadodepartamento) {
        this.estadodepartamento = estadodepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public Long getIdpais() {
        return idpais;
    }

    public void setIdpais(Long idpais) {
        this.idpais = idpais;
    }

    public String getcodigopais() {
        return codigopais;
    }

    public void setcodigopais(String codigopais) {
        this.codigopais = codigopais;
    }

    public String getEstadopais() {
        return estadopais;
    }

    public void setEstadopais(String estadopais) {
        this.estadopais = estadopais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

}
