
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.person.facade.impl;

import com.app.app.domains.person.Person;
import com.app.app.domains.user.User;
import com.app.app.interfaces.cityPerson.dto.CityPersonDTO;
import com.app.app.interfaces.cityPerson.facade.CityPersonFacade;
import com.app.app.interfaces.person.dto.PersonDTO;
import com.app.app.interfaces.person.dto.PersonWeatherDTO;
import com.app.app.interfaces.person.facade.PersonFacade;
import com.app.app.interfaces.person.service.PersonService;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.user.service.UserService;
import com.app.app.utils.ConstanteUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import com.app.app.jms.messages.JmsUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DESARROLLO
 */
@Component("PersonFacade")
public class PersonFacadeImpl implements PersonFacade {

    @Autowired
    PersonService personService;

    @Autowired
    UserService userService;

    @Autowired
    CityPersonFacade cityPersonFacade;

    @Autowired
    JmsUserService jmsUserService;

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
//            personDTO = objectMapper.convertValue(person, PersonDTO.class);
            personDTO.setId(Integer.parseInt(person.id().toString()));
            personDTO.setUserDTO(userDTO);
            PersonWeatherDTO personWeatherDTO = new PersonWeatherDTO();
            personWeatherDTO.setListCityDelete(new ArrayList<>());
            personWeatherDTO.setListFrecuentCity(new ArrayList<>());
            List<CityPersonDTO> cityPersonDTOs = cityPersonFacade.findByIdPerson(person.id());
            cityPersonDTOs.stream().forEach((cityPersonDTO) -> {
                boolean flag = false;
                for (Long idCity : personDTO.getListFrecuentCity()) {
                    if (Objects.equals(idCity, cityPersonDTO.getIdCity())) {
                        flag = true;
                    }
                }
                if (!flag) {
                    personWeatherDTO.getListCityDelete().add(cityPersonDTO.getId());
                }
            });

            personWeatherDTO.getListCityDelete().forEach((id) -> {
                cityPersonFacade.delete(id);
            });

            personDTO.getListFrecuentCity().stream().forEach((idCity) -> {
                CityPersonDTO cityPersonDTO = cityPersonFacade.findByIdCityAndIdPerson(idCity, person.id());
                if (cityPersonDTO == null) {
                    cityPersonDTO = new CityPersonDTO();
                    cityPersonDTO.setIdCity(idCity);
                    cityPersonDTO.setIdPerson(person.id());
                    personWeatherDTO.getListFrecuentCity().add(cityPersonFacade.save(cityPersonDTO));
                }
            });

            personWeatherDTO.setBirthDate(personDTO.getBirthDate());
            personWeatherDTO.setEmail(personDTO.getEmail());
            personWeatherDTO.setId(personDTO.getId());
            personWeatherDTO.setIdBornCity(personDTO.getIdBornCity());
            personWeatherDTO.setIdGender(personDTO.getIdGender());
            personWeatherDTO.setIdState(personDTO.getIdState());
            personWeatherDTO.setLastname(personDTO.getLastname());
            personWeatherDTO.setName(personDTO.getName());
            personWeatherDTO.setPhone(personDTO.getPhone());
            personWeatherDTO.setUserDTO(personDTO.getUserDTO());

            jmsUserService.sendPerson(personWeatherDTO);
            personDTO.getUserDTO().setPassword(null);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(personDTO);
            return responseUtil;
        } catch (DataIntegrityViolationException da) {
            System.out.println("getRootCause().getMessage " + da.getRootCause().getMessage());
            responseUtil.setMessage(ConstanteUtil.MSG_RESTRICTION_EMAIL);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        } catch (IllegalArgumentException | NoSuchAlgorithmException p) {
            Logger.getLogger(PersonFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }
}
