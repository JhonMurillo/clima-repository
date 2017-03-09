/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.userAccess.facade;

import com.app.app.interfaces.userAccess.dto.UserAccessDTO;

/**
 *
 * @author DESARROLLO
 */
public interface UserAccessFacade {

    public void save(UserAccessDTO accessDTO);
}
