/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.web;

import com.app.demo.utils.ResponseUtil;
import com.app.demo.interfaces.barrio.dto.BarrioAllDTO;
import com.app.demo.interfaces.barrio.facade.BarrioFacade;
import com.app.demo.interfaces.barrio.dto.BarrioDTO;
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

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Barrio")
@Api(value = "Barrio microservice", description = "This API has a CRUD for Barrio")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class controllerBarrio {

    @Autowired
    BarrioFacade barrioFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return a List BarrioDTO")
    public List<BarrioDTO> findAll() {
        return barrioFacade.findAll();
    }

    @RequestMapping(value = "findByEstado/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByEstado/{estado}", notes = "Return a List BarrioDTO Por Estado")
    public List<BarrioDTO> findByEstado(@PathVariable("estado") String estado) {
        return barrioFacade.findByEstado(estado);
    }
    
    @RequestMapping(value = "findByNombre/{nombre}", method = RequestMethod.GET)
    @ApiOperation(value = "findByNombre/{nombre}", notes = "Return a List BarrioDTO Por Nombre")
    public List<BarrioDTO> findByNombre(@PathVariable("nombre") String nombre) {
        return barrioFacade.findByNombre(nombre);
    }

    @RequestMapping(value = "findByCodigo/{codigo}", method = RequestMethod.GET)
    @ApiOperation(value = "findByCodigo/{codigo}", notes = "Return a BarrioDTO Por Id")
    public BarrioDTO findByCodigo(@PathVariable("codigo") String codigo) {
        return barrioFacade.findByCodigo(codigo);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a BarrioDTO Por Codigo")
    public BarrioDTO findById(@PathVariable("id") Long id) {
        return barrioFacade.findById(id);
    }

    @RequestMapping(value = "findInfoAll", method = RequestMethod.GET)
    @ApiOperation(value = "findInfoAll", notes = "Return a List BarrioAllDTO ")
    public List<BarrioAllDTO> findInfoAll() {
        return barrioFacade.findInfoAll();
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
    @ApiOperation(value = "Save Barrio", notes = "Return ResponseUtil")
    public ResponseUtil registrarBarrio(@RequestBody @Valid BarrioDTO barrioDTO) {
        return barrioFacade.registrarBarrio(barrioDTO);
    }
//    
//    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
//    @ApiOperation(value = "Delete user", notes = "Return ResponseUtil")
//    public ResponseUtil EliminarUser(@PathVariable("id") Integer id) {
//        return userService.eliminarUser(id);
//    }
}
