/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.login.facade.impl;

import com.app.app.domains.person.Person;
import com.app.app.domains.user.User;
import com.app.app.infraestruct.AuthUtils;
import com.app.app.infraestruct.PasswordService;
import com.app.app.interfaces.login.facade.LoginFacade;
import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.interfaces.person.service.PersonService;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.user.service.UserService;
import com.app.app.utils.ConstanteUtil;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO 13
 */
@Service
public class LoginFacadeImpl implements LoginFacade {

    public final static Logger LOG = LoggerFactory.getLogger(LoginFacadeImpl.class);

    @Context
    HttpHeaders headers;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @Autowired
    private AuthUtils authUtils;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil login(UserDTO credentials, HttpServletRequest request) {
        ResponseUtil responseUtil = new ResponseUtil();
        User userAccess = new User();
        Person person = new Person();
        if (StringUtils.isEmpty(credentials.getPassword()) || StringUtils.isEmpty(credentials.getUserName())) {
            responseUtil.setMessage(ConstanteUtil.MSG_ERROR_AUTENTICACION);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        userAccess = userService.findByUserName(credentials.getUserName());
        if (userAccess == null) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        person = personService.findById(userAccess.idPerson());
        if (person != null && person.state().equals(ConstanteUtil.STATE_ACTIVO)) {
            boolean passok = PasswordService.equalsPassword(credentials.getPassword(), userAccess.password());
            if (passok) {
                PersonDTO personDTO = new PersonDTO();
                UserDTO userDTO = new UserDTO(userAccess.id(), userAccess.userName(), null, userAccess.idPerson());

                personDTO = objectMapper.convertValue(person, PersonDTO.class);
                personDTO.setUserDTO(userDTO);

                String tokenStr = authUtils.createLoginToken(request.getRemoteHost(), userAccess);
                responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
                responseUtil.setTipo(ConstanteUtil.CODE_OK);
                responseUtil.setToken(tokenStr);

                try {
                    responseUtil.setObjectResponse(objectMapper.readTree(objectMapper.writeValueAsString(personDTO)));
                } catch (JsonProcessingException ex) {
                    LOG.warn("Error : " + ex);
                } catch (IOException ex) {
                    LOG.error("Error : " + ex);
                }
                return responseUtil;
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_PASS_NO_VALIDAD);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            }
        } else {
            if (userAccess == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_NO_ACCESS);
                responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
            }
        }

        return responseUtil;
    }

}
