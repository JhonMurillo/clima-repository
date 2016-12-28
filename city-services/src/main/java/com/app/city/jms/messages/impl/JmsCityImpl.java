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
import javax.jms.JMSException;
import javax.jms.Message;
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

//    @Value("${messages.queue.jmscity}")
//    private String queueJmsSendCity;
    @Autowired
    private ActiveMQTopic topicJmsCity;

    @Autowired
    private ValueListFacade valueListFacade;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();
//
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
//

//    @Override
//    public void sendCity(CityDTO cityDTO) {
//        MessageCreator messageCreator = new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                try {
//                    String json = mapper.writeValueAsString(cityDTO);
//                    return session.createTextMessage(json);
//                } catch (JsonProcessingException e) {
//                    LOG.error(" Error al crear json para creación de cola  : " + e);
//                }
//                return null;
//            }
//        };
//        try {
//            jmsTemplate.send(queueJmsSendCity, messageCreator);
//        } catch (Exception e) {
//            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
//        }
//    }
    @Override
    public void sendCity(CityDTO cityDTO) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                try {
                    String json = mapper.writeValueAsString(cityDTO);
                    return session.createTextMessage(json);
                } catch (JsonProcessingException e) {
                    LOG.error(" Error al crear json para creación de cola  : " + e);
                }
                return null;
            }
        };
        try {
            jmsTemplate.send(topicJmsCity, messageCreator);
        } catch (Exception e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
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
