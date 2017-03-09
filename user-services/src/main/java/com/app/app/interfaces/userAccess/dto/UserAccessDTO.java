/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.userAccess.dto;

import java.util.Calendar;

/**
 *
 * @author DESARROLLO
 */
public class UserAccessDTO {

    private Long id;
    private Long idUser;
    private String stateLogin;
    private String token;
    private String stateToken;
    private Calendar loginDate;
    private Calendar logoutDate;

    public UserAccessDTO() {
    }

    public UserAccessDTO(Long id, Long idUser, String stateLogin, String token, String stateToken, Calendar loginDate, Calendar logoutDate) {
        this.id = id;
        this.idUser = idUser;
        this.stateLogin = stateLogin;
        this.token = token;
        this.stateToken = stateToken;
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getStateLogin() {
        return stateLogin;
    }

    public void setStateLogin(String stateLogin) {
        this.stateLogin = stateLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
        this.stateToken = stateToken;
    }

    public Calendar getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Calendar loginDate) {
        this.loginDate = loginDate;
    }

    public Calendar getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Calendar logoutDate) {
        this.logoutDate = logoutDate;
    }

}
