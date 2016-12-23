/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.login.web;

import com.app.app.interfaces.login.dto.LogoutDTO;
import com.app.app.interfaces.login.facade.LoginFacade;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Auth")
@Api(value = "Auth RestController", description = "This API has a Methods of Auth")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerLogin {

    @Autowired
    LoginFacade loginFacade;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Login", notes = "Return ResponseUtil")
    public ResponseUtil login(@RequestBody @Valid UserDTO credentials, @Context HttpServletRequest request) {
        return loginFacade.login(credentials, request);
    }

    @RequestMapping(value = "Logout", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Logout", notes = "Return ResponseUtil")
    public ResponseUtil logout(@RequestBody @Valid LogoutDTO logoutDTO) {
        return loginFacade.logout(logoutDTO);
    }

}
