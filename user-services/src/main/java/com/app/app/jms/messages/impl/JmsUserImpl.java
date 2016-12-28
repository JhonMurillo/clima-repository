package com.app.app.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.app.interfaces.city.dto.CityDTO;
import com.app.app.interfaces.city.facade.CityFacade;
import com.app.app.interfaces.person.dto.PersonWeatherDTO;
import com.app.app.interfaces.valueList.dto.ValueListDTO;
import com.app.app.interfaces.valueList.facade.ValueListFacade;
import com.app.app.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.app.app.jms.messages.JmsUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsUserImpl implements JmsUserService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsUserImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${messages.queue.jmsuser}")
    private String queueJmsSendUser;

    @Autowired
    private CityFacade cityFacade;

    @Autowired
    private ValueListFacade valueListFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

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

    @Override
    public void sendPerson(PersonWeatherDTO personWeatherDTO) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                try {
                    String json = mapper.writeValueAsString(personWeatherDTO);
                    return session.createTextMessage(json);
                } catch (JsonProcessingException e) {
                    LOG.error(" Error al crear json para creación de cola  : " + e);
                }
                return null;
            }
        };
        try {
            jmsTemplate.send(queueJmsSendUser, messageCreator);
        } catch (Exception e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }

    @JmsListener(destination = "${messages.queue.jmsvaluelist}", containerFactory = "jmsTopicListenerContainerFactory")
    @Override
    public void createValueList(String valueList) {
        try {
            ValueListDTO valueListDTO = mapper.convertValue(mapper.readTree(valueList), ValueListDTO.class);
            valueListFacade.save(valueListDTO);
        } catch (IOException | IllegalArgumentException e) {
            LOG.error("Error : " + e);
        }
    }
}
