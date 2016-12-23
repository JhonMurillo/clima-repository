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
public class LogoutDTO {

    private Long idUserAccess;
    private Long idUser;
    private String token;

    public LogoutDTO() {
    }

    public LogoutDTO(Long idUserAccess, Long idUser, String token) {
        this.idUserAccess = idUserAccess;
        this.idUser = idUser;
        this.token = token;
    }

    public Long getIdUserAccess() {
        return idUserAccess;
    }

    public void setIdUserAccess(Long idUserAccess) {
        this.idUserAccess = idUserAccess;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
