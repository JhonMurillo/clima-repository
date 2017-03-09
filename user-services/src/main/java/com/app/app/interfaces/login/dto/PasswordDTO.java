/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.login.dto;

/**
 *
 * @author DESARROLLO
 */
public class PasswordDTO {

    private Long idPerson;
    private String actualPassword;
    private String newPassword;

    public PasswordDTO() {
    }

    public PasswordDTO(String actualPassword, String newPassword) {
        this.actualPassword = actualPassword;
        this.newPassword = newPassword;
    }

    public PasswordDTO(Long idPerson, String actualPassword, String newPassword) {
        this.idPerson = idPerson;
        this.actualPassword = actualPassword;
        this.newPassword = newPassword;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getActualPassword() {
        return actualPassword;
    }

    public void setActualPassword(String actualPassword) {
        this.actualPassword = actualPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
