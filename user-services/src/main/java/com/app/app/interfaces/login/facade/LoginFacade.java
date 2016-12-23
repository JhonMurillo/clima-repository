/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.login.facade;

import com.app.app.interfaces.login.dto.LogoutDTO;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.utils.ResponseUtil;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DESARROLLO 13
 */
public interface LoginFacade {

    public ResponseUtil login(UserDTO credentials, HttpServletRequest request);

    public ResponseUtil logout(LogoutDTO logoutDTO);

}
