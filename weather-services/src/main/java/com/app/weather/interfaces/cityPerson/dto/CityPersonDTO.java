/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.cityPerson.dto;

/**
 *
 * @author DESARROLLO
 */
public class CityPersonDTO {

    private Long id;
    private Long idPerson;
    private Long idCity;

    public CityPersonDTO() {
    }

    public CityPersonDTO(Long id, Long idPerson, Long idCity) {
        this.id = id;
        this.idPerson = idPerson;
        this.idCity = idCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

}
