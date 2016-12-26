/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.userAccess.service;

import com.app.weather.domains.userAccess.UserAccess;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface UserAccessService {

    UserAccess save(UserAccess userAccess);

    UserAccess findById(Long id);

    UserAccess findByIdUser(Long idUser);

    UserAccess findByToken(String token);

    List<UserAccess> findByStateLogin(String stateLogin);

}
