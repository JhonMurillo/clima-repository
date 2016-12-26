/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.weather.interfaces.person.facade.impl;

import com.app.weather.domains.person.Person;
import com.app.weather.domains.user.User;
import com.app.weather.interfaces.person.dto.PersonDTO;
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

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil savePerson(PersonDTO personDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            UserDTO userDTO = personDTO.getUserDTO();
            Person person = objectMapper.convertValue(personDTO, Person.class);
            personService.save(person);
            userDTO.setIdPerson(person.id());
            User user = objectMapper.convertValue(userDTO, User.class);
            userService.save(user);
            userDTO = objectMapper.convertValue(user, UserDTO.class);
            personDTO = objectMapper.convertValue(person, PersonDTO.class);
            userDTO.setPassword(null);
            personDTO.setUserDTO(userDTO);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(personDTO);
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
}
