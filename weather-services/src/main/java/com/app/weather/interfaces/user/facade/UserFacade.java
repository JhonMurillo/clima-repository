/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.user.facade;

import com.app.weather.interfaces.user.dto.UserDTO;
import com.app.weather.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface UserFacade {

    List<UserDTO> findAll();

    ResponseUtil saveUser(UserDTO userDTO);

    UserDTO findById(Long id);

}
