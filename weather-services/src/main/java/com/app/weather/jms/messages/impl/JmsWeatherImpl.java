package com.app.weather.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.app.interfaces.userAccess.dto.UserAccessDTO;
import com.app.weather.interfaces.city.dto.CityDTO;
import com.app.weather.interfaces.city.facade.CityFacade;
import com.app.weather.interfaces.person.dto.PersonWeatherDTO;
import com.app.weather.utils.ObjectMapperUtil;
import com.app.weather.interfaces.person.facade.PersonFacade;
import com.app.weather.interfaces.user.dto.UserDTO;
import com.app.weather.interfaces.userAccess.facade.UserAccessFacade;
import com.app.weather.interfaces.valueList.dto.ValueListDTO;
import com.app.weather.interfaces.valueList.facade.ValueListFacade;
import com.app.weather.jms.messages.JmsWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsWeatherImpl implements JmsWeatherService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsWeatherImpl.class);

    @Autowired
    private PersonFacade personFacade;

    @Autowired
    private ValueListFacade valueListFacade;

    @Autowired
    private CityFacade cityFacade;
    
    @Autowired
    private UserAccessFacade userAccessFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

    @JmsListener(destination = "${messages.queue.jmsuser}")
    @Override
    public void createPerson(String person) {
        try {
            PersonWeatherDTO personWeatherDTO = mapper.convertValue(mapper.readTree(person), PersonWeatherDTO.class);
            personFacade.savePerson(personWeatherDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        }
    }

    @JmsListener(destination = "${messages.queue.jmsvaluelist}", containerFactory = "jmsTopicListenerContainerFactory")
    @Override
    public void createValueList(String valueList) {
        ValueListDTO valueListDTO = new ValueListDTO();
        try {
            valueListDTO = mapper.readValue(valueList, ValueListDTO.class);
            valueListFacade.save(valueListDTO);
        } catch (IOException e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }

    @JmsListener(destination = "${messages.queue.jmscity}", containerFactory = "jmsTopicListenerContainerFactory")
    @Override
    public void createCity(String city) {
        try {
            CityDTO cityDTO = mapper.convertValue(mapper.readTree(city), CityDTO.class);
            cityFacade.save(cityDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        }
    }

    @JmsListener(destination = "${messages.queue.jmsuserdto}")
    @Override
    public void updateUser(String user) {
        try {
            UserDTO userDTO = mapper.convertValue(mapper.readTree(user), UserDTO.class);
            personFacade.resetPassword(userDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        }
    }

    @JmsListener(destination = "${messages.queue.jmsuseraccessdto}")
    @Override
    public void createOrUpdateUserAccess(String userAccessDTO) {
        try {
            UserAccessDTO accessDTO = mapper.convertValue(mapper.readTree(userAccessDTO), UserAccessDTO.class);
            userAccessFacade.save(accessDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        }
    }
}
