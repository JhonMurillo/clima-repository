/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.domains.cityPerson;

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
@Table(name = "city_person")
@ApiModel("Model CityPerson")
public class CityPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "the  id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  idPerson", required = true)
    private Long idPerson;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  idCity", required = true)
    private Long idCity;

    public CityPerson() {
    }

    public CityPerson(Long id, Long idPerson, Long idCity) {
        this.id = id;
        this.idPerson = idPerson;
        this.idCity = idCity;
    }

    public Long id() {
        return id;
    }

    public Long idPerson() {
        return idPerson;
    }

    public Long idCity() {
        return idCity;
    }

}
