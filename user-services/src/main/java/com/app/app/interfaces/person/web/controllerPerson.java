/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.web;

import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.interfaces.person.facade.PersonFacade;
import com.app.app.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@RequestMapping("/Person")
@Api(value = "Person RestController", description = "This API has a CRUD for Person")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class controllerPerson {

    @Autowired
    PersonFacade personFacade;
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Person", notes = "Return ResponseUtil")
    public ResponseUtil saveUser(@RequestBody @Valid PersonDTO personDTO) {
        return personFacade.savePerson(personDTO);
    }

}
