/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.user.web;

import com.app.app.interfaces.user.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.app.app.utils.ResponseUtil;
import com.app.app.interfaces.user.facade.UserFacade;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/User")
@Api(value = "User RestController", description = "This API has a CRUD for User")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class controllerUser {

    @Autowired
    UserFacade userFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return a List UserDTO")
    public List<UserDTO> findAll() {
        return userFacade.findAll();
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a UserDTO By Id")
    public UserDTO findById(@PathVariable("id") Long id) {
        return userFacade.findById(id);
    }

//
//    @RequestMapping(value = "findById/{id}",method = RequestMethod.GET)
//    @ApiOperation(value = "Find an User by id", notes = "Return a user by Id")
//    public UserDTO findByUserName(@PathVariable("id") Integer id) {
//        return userService.findById(id);
//    }
//    
//    @RequestMapping(method = RequestMethod.GET)
//    @ApiOperation(value = "Find all users", notes = "Return all users")
//    public List<UserDTO> findAll() {
//        return userService.findAll();
//    }
//    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save User", notes = "Return ResponseUtil")
    public ResponseUtil saveUser(@RequestBody @Valid UserDTO userDTO) {
        return userFacade.saveUser(userDTO);
    }
//    
//    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
//    @ApiOperation(value = "Delete user", notes = "Return ResponseUtil")
//    public ResponseUtil EliminarUser(@PathVariable("id") Integer id) {
//        return userService.eliminarUser(id);
//    }
}
