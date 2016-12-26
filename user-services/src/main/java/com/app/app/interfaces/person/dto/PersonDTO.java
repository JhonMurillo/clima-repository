/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.dto;

import com.app.app.interfaces.user.dto.UserDTO;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    private Long idState;
    private Long idGender;
    private Date birthDate;
    private Long idBornCity;
    private String bornCity;
    private UserDTO userDTO;
    private List<Long> listFrecuentCity;

    public PersonDTO() {
    }

    public PersonDTO(Integer id, String name, String lastname, String phone, String email, Long idState, UserDTO userDTO) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.idState = idState;
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

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public Long getIdGender() {
        return idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
    }

    public Long getIdBornCity() {
        return idBornCity;
    }

    public void setIdBornCity(Long idBornCity) {
        this.idBornCity = idBornCity;
    }

    public List<Long> getListFrecuentCity() {
        return listFrecuentCity;
    }

    public void setListFrecuentCity(List<Long> listFrecuentCity) {
        this.listFrecuentCity = listFrecuentCity;
    }

}
