/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.userAccess.service.impl;

import com.app.app.domains.userAccess.UserAccess;
import com.app.app.domains.userAccess.UserAccessRepository;
import com.app.app.interfaces.login.dto.LogoutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.app.interfaces.userAccess.service.UserAccessService;

/**
 *
 * @author DESARROLLO
 */
@Component("UserAccessService")
@Service
public class UserAccessServiceImpl implements UserAccessService {

    @Autowired
    UserAccessRepository userAccessRepository;

    @Override
    public UserAccess save(UserAccess userAccess) {
        return userAccessRepository.save(userAccess);
    }

    @Override
    public UserAccess findById(Long id) {
        return userAccessRepository.findOne(id);
    }

    @Override
    public UserAccess findByIdUser(Long idUser) {
        return userAccessRepository.findByIdUser(idUser);
    }

    @Override
    public UserAccess findByToken(String token) {
        return userAccessRepository.findByToken(token);
    }

    @Override
    public List<UserAccess> findByStateLogin(String stateLogin) {
        return (List<UserAccess>) userAccessRepository.findByStateLogin(stateLogin);
    }
    
    @Override
    public UserAccess findLogout(LogoutDTO logoutDTO,String stateLogin,String stateToken) {
        return userAccessRepository.findLogout(logoutDTO.getIdUserAccess(),logoutDTO.getIdUser(), logoutDTO.getToken(), stateLogin, stateToken);
    }

}
