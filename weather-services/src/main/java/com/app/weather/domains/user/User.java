/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.domains.user;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "t_user", uniqueConstraints = @UniqueConstraint(columnNames = "user_name", name = "uk_user_name_user"))
@ApiModel("Model User")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Long id;
    @Column(nullable = false, name = "user_name")
    @ApiModelProperty(value = "the  userName", required = true)
    private String userName;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  password", required = true)
    private String password;
//    @Column(nullable = false)
    @ApiModelProperty(value = "the  id person", required = true)
    @JoinColumn(referencedColumnName = "id",
            table = "person",
            insertable = false,
            updatable = false,
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_id_person"))
    private Long idPerson;

    public User() {
    }

    public User(Long id, String userName, String password, Long idPerson) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.idPerson = idPerson;
    }

    public Long id() {
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

    public Long idPerson() {
        return idPerson;
    }

}
