package com.app.valueList.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.valueList.utils.ObjectMapperUtil;
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
import com.app.valueList.jms.messages.JmsValueListService;
import com.app.valueList.interfaces.valueList.dto.ValueListDTO;
import org.apache.activemq.command.ActiveMQTopic;

/**
 *
 * @author DESARROLLO 13
 */
@Component
public class JmsValueListImpl implements JmsValueListService {

    public final static Logger LOG = LoggerFactory.getLogger(JmsValueListImpl.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    private ActiveMQTopic topicJmsValueList;

    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public void sendValueList(ValueListDTO valueListDTO) {
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                try {
                    String json = mapper.writeValueAsString(valueListDTO);
                    return session.createTextMessage(json);
                } catch (JsonProcessingException e) {
                    LOG.error(" Error al crear json para creación de cola  : " + e);
                }
                return null;
            }
        };
        try {
            jmsTemplate.send(topicJmsValueList, messageCreator);
        } catch (Exception e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }
}
