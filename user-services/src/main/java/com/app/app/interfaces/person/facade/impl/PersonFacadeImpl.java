/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.facade.impl;

import com.app.app.domains.person.Person;
import com.app.app.domains.user.User;
import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.interfaces.person.facade.PersonFacade;
import com.app.app.interfaces.person.service.PersonService;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.user.service.UserService;
import com.app.app.utils.ConstanteUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;
import com.app.app.jms.messages.JmsUserService;

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
    JmsUserService jmsUser;
    
    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();
    
    @Override
    public ResponseUtil savePerson(PersonDTO personDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            UserDTO userDTO = personDTO.getUserDTO();
            userDTO.setPassword(com.app.app.utils.Encrytacion.getMd5(userDTO.getPassword()));
            Person person = objectMapper.convertValue(personDTO, Person.class);
            personService.save(person);
            userDTO.setIdPerson(person.id());
            User user = objectMapper.convertValue(userDTO, User.class);
            userService.save(user);
            userDTO = objectMapper.convertValue(user, UserDTO.class);
            personDTO = objectMapper.convertValue(person, PersonDTO.class);
            personDTO.setUserDTO(userDTO);
//            jmsUser.sendUser(personDTO);
            personDTO.getUserDTO().setPassword(null);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(personDTO);
            return responseUtil;
        } catch (IllegalArgumentException | NoSuchAlgorithmException p) {
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
