/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.person.facade.impl;

import com.app.weather.domains.person.Person;
import com.app.weather.domains.user.User;
import com.app.weather.interfaces.cityPerson.dto.CityPersonDTO;
import com.app.weather.interfaces.cityPerson.facade.CityPersonFacade;
import com.app.weather.interfaces.person.dto.PersonWeatherDTO;
import com.app.weather.interfaces.person.facade.PersonFacade;
import com.app.weather.interfaces.person.service.PersonService;
import com.app.weather.interfaces.user.dto.UserDTO;
import com.app.weather.interfaces.user.service.UserService;
import com.app.weather.utils.ConstanteUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.weather.utils.ObjectMapperUtil;
import com.app.weather.utils.ResponseUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

/**
 *
 * @author DESARROLLO
 */
@Component("PersonFacade")
@Transactional
public class PersonFacadeImpl implements PersonFacade {

    @Autowired
    PersonService personService;

    @Autowired
    UserService userService;

    @Autowired
    CityPersonFacade cityPersonFacade;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil savePerson(PersonWeatherDTO personWeatherDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            UserDTO userDTO = personWeatherDTO.getUserDTO();
            Person person = objectMapper.convertValue(personWeatherDTO, Person.class);
            personService.save(person);
            userDTO.setIdPerson(person.id());
            User user = objectMapper.convertValue(userDTO, User.class);
            userService.save(user);
            userDTO = objectMapper.convertValue(user, UserDTO.class);
//            personWeatherDTO = objectMapper.convertValue(person, PersonWeatherDTO.class);
            personWeatherDTO.setId(Integer.parseInt(person.id().toString()));
            userDTO.setPassword(null);
            personWeatherDTO.setUserDTO(userDTO);

            personWeatherDTO.getListCityDelete().forEach((id) -> {
                cityPersonFacade.delete(id);
            });

//            personWeatherDTO.getListFrecuentCity().stream().forEach((cityPersonDTO) -> {
//                cityPersonFacade.save(cityPersonDTO);
//            });
            for (CityPersonDTO cityPersonDTO : personWeatherDTO.getListFrecuentCity()) {
                cityPersonFacade.save(cityPersonDTO);
            }

            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(personWeatherDTO);
            return responseUtil;
        } catch (IllegalArgumentException p) {
            Logger.getLogger(PersonFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
        } catch (DataIntegrityViolationException | TransactionSystemException da) {
            System.out.println("getRootCause().getMessage " + da.getRootCause().getMessage());
            responseUtil.setMessage(da.getRootCause().getMessage());
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public ResponseUtil resetPassword(UserDTO userDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        userService.save(objectMapper.convertValue(userDTO, User.class));
        responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
        responseUtil.setTipo(ConstanteUtil.CODE_OK);
        return responseUtil;
    }
}
