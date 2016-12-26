/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.userAccess.service.impl;

import com.app.weather.domains.userAccess.UserAccess;
import com.app.weather.domains.userAccess.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.weather.interfaces.userAccess.service.UserAccessService;

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
    
}
