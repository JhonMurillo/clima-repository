/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.valueList.interfaces.valueList.web;

import com.app.valueList.interfaces.valueList.dto.ValueListDTO;
import com.app.valueList.interfaces.valueList.facade.ValueListFacade;
import com.app.valueList.utils.ResponseUtil;
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
@RequestMapping("/ValueList")
@Api(value = "ValueList RestController", description = "This API has a Methods for ValueList")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerValueList {

    @Autowired
    ValueListFacade valueListFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return a List ValueListDTO")
    public List<ValueListDTO> findAll() {
        return valueListFacade.findAll();
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a ValueListDTO By Id")
    public ValueListDTO findById(@PathVariable("id") Long id) {
        return valueListFacade.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save ValueList", notes = "Return ResponseUtil")
    public ResponseUtil saveValueList(@RequestBody @Valid ValueListDTO valueListDTO) {
        return valueListFacade.save(valueListDTO);
    }

    @RequestMapping(value = "findByCategoryAndValue/{category}/{value}", method = RequestMethod.GET)
    @ApiOperation(value = "findByCategoryAndValue/{category}/{value}", notes = "Return a ValueListDTO By category and value")
    public ValueListDTO findByCategoryAndValue(@PathVariable("category") String category, @PathVariable("value") String value) {
        return valueListFacade.findByCategoryAndValue(category, value);
    }

    @RequestMapping(value = "findByCategory/{category}", method = RequestMethod.GET)
    @ApiOperation(value = "findByCategory/{category}", notes = "Return a ValueListDTO By category")
    public List<ValueListDTO> findByCategory(@PathVariable("category") String category) {
        return valueListFacade.findByCategory(category);
    }

}
