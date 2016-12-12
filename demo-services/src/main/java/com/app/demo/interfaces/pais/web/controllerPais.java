/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.pais.web;

import com.app.demo.interfaces.pais.facade.PaisFacade;
import io.swagger.annotations.Api;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Pais")
@Api(value = "Pais microservice", description = "This API has a CRUD for Pais")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class controllerPais {

    @Autowired
    PaisFacade paisFacade;

//    @RequestMapping(value = "findByUserName/{userName}",method = RequestMethod.GET)
//    @ApiOperation(value = "Find user by userName", notes = "Return a userDTO")
//    public UserDTO findByUserName(@PathVariable("userName") String userName) {
//        return userService.findByUserName(userName);
//    }
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
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value = "Save user", notes = "Return ResponseUtil")
//    public ResponseUtil registrarUser(@RequestBody @Valid UserDTO userDTO) {
//        return userService.registrarUser(userDTO);
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
//    @ApiOperation(value = "Delete user", notes = "Return ResponseUtil")
//    public ResponseUtil EliminarUser(@PathVariable("id") Integer id) {
//        return userService.eliminarUser(id);
//    }
}
