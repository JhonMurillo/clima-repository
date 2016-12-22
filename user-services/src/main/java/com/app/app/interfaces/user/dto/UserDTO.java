/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.user.dto;

/**
 *
 * @author DESARROLLO
 */
public class UserDTO {

    private Long id;
    private String userName;
    private String password;
    private Long idPerson;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String password, Long idPerson) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.idPerson = idPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

}
