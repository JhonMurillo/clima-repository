/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.jms.messages;

import com.app.app.interfaces.login.dto.ResetPasswordDTO;
import com.app.app.interfaces.person.dto.PersonWeatherDTO;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.userAccess.dto.UserAccessDTO;

/**
 *
 * @author Desarrollo4
 */
public interface JmsUserService {

    void createCity(String city);

    void createValueList(String valueList);

    void sendPerson(PersonWeatherDTO personWeatherDTO);

    void sendUser(UserDTO userDTO);

    void sendUserAccess(UserAccessDTO userAccessDTO);

    void sendResetPassword(ResetPasswordDTO resetPasswordDTO);
    
    void sendRegistry(ResetPasswordDTO resetPasswordDTO);
}
