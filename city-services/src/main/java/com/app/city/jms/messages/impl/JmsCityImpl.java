package com.app.city.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.city.interfaces.city.dto.CityDTO;
import com.app.city.interfaces.valueList.dto.ValueListDTO;
import com.app.city.interfaces.valueList.facade.ValueListFacade;
import com.app.city.utils.ObjectMapperUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.jms.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import com.app.city.jms.messages.JmsCityService;
import java.io.IOException;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsCityImpl implements JmsCityService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsCityImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQTopic topicJmsCity;

    @Autowired
    private ValueListFacade valueListFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public void sendCity(CityDTO cityDTO) {
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(cityDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error creating : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(topicJmsCity, messageCreator);
        } catch (JmsException e) {
            LOG.error("Error sending   :" + e);
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
}
