package com.app.weather.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.weather.utils.ObjectMapperUtil;
import com.app.weather.interfaces.person.dto.PersonDTO;
import com.app.weather.interfaces.person.facade.PersonFacade;
import com.app.weather.jms.messages.JmsWeatherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsWeatherImpl implements JmsWeatherService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsWeatherImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private PersonFacade personFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

//    @JmsListener(destination = "${mensajes.queue.jmslisteneruser}")
//    @Override
//    public void userCreado(String person) {
//        try {
//            PersonDTO personDTO = mapper.convertValue(mapper.readTree(person), PersonDTO.class);
//            personFacade.savePerson(personDTO);
//        } catch (IOException | IllegalArgumentException e) {
//            LOG.error("Error : " + e);
//        }
//    }
}
