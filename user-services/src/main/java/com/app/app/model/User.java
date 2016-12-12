/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "user")
@ApiModel("Model User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Integer id;
    @Column(nullable = false, unique = true)
    @ApiModelProperty(value = "the  userName", required = true)
    private String userName;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  password", required = true)
    private String password;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  id person", required = true)
//    @OneToOne
    private Integer idPerson;

    public User() {
    }

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer id() {
        return id;
    }

    public String userName() {
        return userName;
    }

    public String password() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", idPerson=" + idPerson + '}';
    }

    public Integer idPerson() {
        return idPerson;
    }

}
