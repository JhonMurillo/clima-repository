/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.city.interfaces.city.web;

import com.app.city.interfaces.city.dto.CityDTO;
import com.app.city.interfaces.city.facade.CityFacade;
import com.app.city.utils.ResponseUtil;
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
@RequestMapping("/City")
@Api(value = "City microservice", description = "This API has a CRUD for City")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerCity {

    @Autowired
    CityFacade cityFacade;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return All CityDTO")
    public List<CityDTO> findAll() {
        return cityFacade.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save City", notes = "Return ResponseUtil")
    public ResponseUtil save(@RequestBody @Valid CityDTO cityDTO) {
        return cityFacade.save(cityDTO);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a CityDTO")
    public CityDTO findById(@PathVariable("id") Long id) {
        return cityFacade.findById(id);
    }

    @RequestMapping(value = "findByName/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "findByName/{name}", notes = "Return  CityDTOs By Name")
    public List<CityDTO> findByName(@PathVariable("name") String name) {
        return cityFacade.findByName(name);
    }

    @RequestMapping(value = "findByIdState/{idState}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdState/{idState}", notes = "Return  CityDTOs By idState")
    public List<CityDTO> findByIdState(@PathVariable("idState") Long idState) {
        return cityFacade.findByIdState(idState);
    }

    @RequestMapping(value = "findByCode/{code}", method = RequestMethod.GET)
    @ApiOperation(value = "findByCode/{code}", notes = "Return a CityDTO By Code")
    public CityDTO findByCode(@PathVariable("code") String code) {
        return cityFacade.findByCode(code);
    }

    @RequestMapping(value = "findByLatitudeAndLongitude/{latitude}/{longitude}", method = RequestMethod.GET)
    @ApiOperation(value = "findByLatitudeAndLongitude/{latitude}/{longitude}", notes = "Return a CityDTO By latitude And ")
    public CityDTO findByLatitudeAndLongitude(@PathVariable("latitude") String latitude, @PathVariable("longitude") String longitude) {
        return cityFacade.findByLatitudeAndLongitude(latitude, longitude);
    }

    @RequestMapping(value = "findByNameLike/{name}", method = RequestMethod.GET)
    @ApiOperation(value = "findByNameLike/{name}", notes = "Return  CityDTOs By Name Like")
    public List<CityDTO> findByNameLike(@PathVariable("name") String name) {
        return cityFacade.findByNameLike(name.toLowerCase());
    }

}
