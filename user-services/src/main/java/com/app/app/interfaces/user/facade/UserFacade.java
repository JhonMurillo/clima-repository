/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.user.facade;

import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.utils.ResponseUtil;
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
