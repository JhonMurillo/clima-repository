/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.domains.city;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "city", schema = "public", uniqueConstraints
        = @UniqueConstraint(columnNames = "code", name = "uk_code_city")
)
@ApiModel("Model City")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "code", required = true)
    private String code;
    @Column(nullable = false)
    @ApiModelProperty(value = "name", required = true)
    private String name;
    @Column(nullable = false)
    @ApiModelProperty(value = "state", required = true)
    private Long idState;
    @Column(nullable = false)
    @ApiModelProperty(value = "latitude", required = true)
    private String latitude;
    @Column(nullable = false)
    @ApiModelProperty(value = "longitude", required = true)
    private String longitude;

    public City() {
    }

    public City(Long id, String code, String name, Long idState, String latitude, String longitude) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.idState = idState;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long id() {
        return id;
    }

    public String code() {
        return code;
    }

    public String name() {
        return name;
    }

    public Long idState() {
        return idState;
    }

    public String latitude() {
        return latitude;
    }

    public String longitude() {
        return longitude;
    }

}
