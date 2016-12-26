/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.userAccess.facade.impl;

import com.app.weather.interfaces.userAccess.facade.UserAccessFacade;
import com.app.weather.interfaces.userAccess.service.UserAccessService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.weather.utils.ObjectMapperUtil;

/**
 *
 * @author DESARROLLO
 */
@Component("UserAccessFacade")
@Transactional
public class UserAccessFacadeImpl implements UserAccessFacade {

    @Autowired
    UserAccessService userAccessService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

}
