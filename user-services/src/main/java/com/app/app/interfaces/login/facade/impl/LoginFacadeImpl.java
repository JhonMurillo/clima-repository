/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.login.facade.impl;

import com.app.app.domains.person.Person;
import com.app.app.domains.user.User;
import com.app.app.domains.userAccess.UserAccess;
import com.app.app.jms.AuthUtils;
import com.app.app.jms.PasswordService;
import com.app.app.interfaces.login.dto.LogoutDTO;
import com.app.app.interfaces.login.dto.PasswordDTO;
import com.app.app.interfaces.login.dto.ResetPasswordDTO;
import com.app.app.interfaces.login.facade.LoginFacade;
import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.interfaces.person.service.PersonService;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.user.service.UserService;
import com.app.app.interfaces.userAccess.dto.UserAccessDTO;
import com.app.app.interfaces.userAccess.service.UserAccessService;
import com.app.app.interfaces.valueList.service.ValueListService;
import com.app.app.jms.messages.JmsUserService;
import com.app.app.utils.ConstanteUtil;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
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
    private UserAccessService userAccessService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ValueListService valueListService;

    @Autowired
    private AuthUtils authUtils;

    @Autowired
    JmsUserService jmsUserService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil login(UserDTO credentials, HttpServletRequest request) {
        ResponseUtil responseUtil = new ResponseUtil();
        User user = new User();
        UserAccess userAccess = new UserAccess();
        Person person = new Person();
        if (StringUtils.isEmpty(credentials.getPassword()) || StringUtils.isEmpty(credentials.getUserName())) {
            responseUtil.setMessage(ConstanteUtil.MSG_ERROR_AUTENTICACION);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        user = userService.findByUserName(credentials.getUserName());
        if (user == null) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        person = personService.findById(user.idPerson());
        String state = "";
        if (person != null) {
            state = valueListService.findById(person.idState()).value();
        }
        if (person != null && state.equals(ConstanteUtil.STATE_ACTIVO)) {
            boolean passok = PasswordService.equalsPassword(credentials.getPassword(), user.password());
            if (passok) {
                PersonDTO personDTO = new PersonDTO();
                UserDTO userDTO = new UserDTO(user.id(), user.userName(), null, user.idPerson());

                personDTO = objectMapper.convertValue(person, PersonDTO.class);

                String tokenStr = authUtils.createLoginToken(request.getRemoteHost(), user);
                userAccess = new UserAccess(null,
                        user.id(),
                        ConstanteUtil.STATE_LOGIN,
                        tokenStr,
                        ConstanteUtil.STATE_INITIATED,
                        new GregorianCalendar(),
                        null);
                userAccessService.save(userAccess);

                jmsUserService.sendUserAccess(objectMapper.convertValue(userAccess, UserAccessDTO.class));

                userDTO.setIdUserAccess(userAccess.id());
                personDTO.setUserDTO(userDTO);
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
            if (user == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_NO_ACCESS);
                responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
            }
        }

        return responseUtil;
    }

    @Override
    public ResponseUtil logout(LogoutDTO logoutDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            UserAccess userAccess = new UserAccess();
            userAccess = userAccessService.findLogout(logoutDTO, ConstanteUtil.STATE_LOGIN, ConstanteUtil.STATE_INITIATED);
            if (userAccess == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_LOGIN);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            userAccess = new UserAccess(userAccess.id(),
                    userAccess.idUser(),
                    ConstanteUtil.STATE_LOGOUT,
                    userAccess.token(),
                    ConstanteUtil.STATE_EXPIRED,
                    userAccess.loginDate(),
                    new GregorianCalendar());
            userAccessService.save(userAccess);
            jmsUserService.sendUserAccess(objectMapper.convertValue(userAccess, UserAccessDTO.class));
            responseUtil.setMessage(ConstanteUtil.MSG_USER_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            return responseUtil;
        } catch (IllegalArgumentException e) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_ERROR_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

    @Override
    public ResponseUtil resetPassword(String email) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            User user = new User();
            user = userService.findByUserName(email);
            if (user == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            String passwordRamdon = com.app.app.utils.Encrytacion.getCadenaAlfanumAleatoria(6);
            String password = com.app.app.utils.Encrytacion.getMd5(passwordRamdon);

            UserDTO userDTO = new UserDTO(user.id(), user.userName(), password, user.idPerson());

            userService.save(objectMapper.convertValue(userDTO, User.class));

            jmsUserService.sendUser(userDTO);

            Person person = personService.findById(user.idPerson());

            StringBuilder nombreCompleto = new StringBuilder();
            nombreCompleto.append(person.name());
            nombreCompleto.append(" ");
            nombreCompleto.append(person.lastname());

            ResetPasswordDTO resetPasswordDTO = new ResetPasswordDTO();
            resetPasswordDTO.setEmail(user.userName());
            resetPasswordDTO.setPassword(passwordRamdon);
            resetPasswordDTO.setNombreCompleto(nombreCompleto.toString());

            jmsUserService.sendResetPassword(resetPasswordDTO);

            responseUtil.setObject(passwordRamdon);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            return responseUtil;
        } catch (NoSuchAlgorithmException e) {
            responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

    @Override
    public ResponseUtil updatePassword(PasswordDTO passwordDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            User user = new User();
            user = userService.findByIdPerson(passwordDTO.getIdPerson());
            if (user == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            boolean passok = PasswordService.equalsPassword(passwordDTO.getActualPassword(), user.password());
            if (passok) {
                String password = com.app.app.utils.Encrytacion.getMd5(passwordDTO.getNewPassword());
                UserDTO userDTO = new UserDTO(user.id(), user.userName(), password, user.idPerson());
                userService.save(objectMapper.convertValue(userDTO, User.class));
                jmsUserService.sendUser(userDTO);
                responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
                responseUtil.setTipo(ConstanteUtil.CODE_OK);
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_PASS_NO_EQUALS);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            }
            return responseUtil;
        } catch (NoSuchAlgorithmException e) {
            responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

}
