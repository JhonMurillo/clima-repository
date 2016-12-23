/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.userAccess.service;

import com.app.app.domains.userAccess.UserAccess;
import com.app.app.interfaces.login.dto.LogoutDTO;
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
    
    UserAccess findLogout(LogoutDTO logoutDTO,String stateLogin,String stateToken);

}
