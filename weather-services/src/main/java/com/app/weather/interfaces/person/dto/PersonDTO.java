/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.person.dto;

import com.app.weather.interfaces.user.dto.UserDTO;
import java.util.Date;

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
    private String gender;
    private Date birthDate;
    private String actualCity;
    private String bornCity;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getActualCity() {
        return actualCity;
    }

    public void setActualCity(String actualCity) {
        this.actualCity = actualCity;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

}
