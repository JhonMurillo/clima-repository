/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "person")
@ApiModel("Model Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Integer id;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  name", required = true)
    private String name;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  lastname", required = true)
    private String lastname;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  phone", required = true)
    private String phone;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "the  email", required = true)
    private String email;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  state", required = true)
    private Character state;

    public Person() {
    }

    public Person(Integer id, String name, String lastname, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Person(Integer id, String name, String lastname, String phone, String email, Character state) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.state = state;
    }

    public Integer id() {
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

    public Character state() {
        return state;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.state);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", lastname=" + lastname + ", phone=" + phone + ", email=" + email + ", state=" + state + '}';
    }

}
