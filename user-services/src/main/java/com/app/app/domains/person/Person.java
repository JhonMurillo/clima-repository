/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.domains.person;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "person", uniqueConstraints
        = @UniqueConstraint(columnNames = "email", name = "uk_email_person")
)
@ApiModel("Model Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  name", required = true)
    private String name;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  lastname", required = true)
    private String lastname;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  phone", required = true)
    private String phone;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  email", required = true)
    private String email;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  idState", required = true)
    private Long idState;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  idGender", required = true)
    private Long idGender;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  birthDate", required = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar birthDate;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  idBornCity", required = true)
    private Long idBornCity;

    public Person() {
    }

    public Person(Long id, String name, String lastname, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Person(Long id, String name, String lastname, String phone, String email, Long idState) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.idState = idState;
    }

    public Person(Long id, String name, String lastname, String phone, String email, Long idState, Long idGender, Calendar birthDate, Long idBornCity) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.idState = idState;
        this.idGender = idGender;
        this.birthDate = birthDate;
        this.idBornCity = idBornCity;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    public String phone() {
        return phone;
    }

    public String email() {
        return email;
    }

    public Long idState() {
        return idState;
    }

    public Calendar birthDate() {
        return birthDate;
    }

    public Long idBornCity() {
        return idBornCity;
    }

    public Long idGender() {
        return idGender;
    }

}
