/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.model.dtos;

/**
 *
 * @author DESARROLLO
 */
public class PersonDTO {

    private Integer id;
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private Character state;
    private UserDTO userDTO;

    public PersonDTO() {
    }

    public PersonDTO(Integer id, String name, String lastname, String phone, String email, Character state, UserDTO userDTO) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.userDTO = userDTO;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Character getState() {
        return state;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(Character state) {
        this.state = state;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
