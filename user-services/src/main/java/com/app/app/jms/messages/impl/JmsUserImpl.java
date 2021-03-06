package com.app.app.jms.messages.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.app.interfaces.city.dto.CityDTO;
import com.app.app.interfaces.city.facade.CityFacade;
import com.app.app.interfaces.login.dto.ResetPasswordDTO;
import com.app.app.interfaces.person.dto.PersonWeatherDTO;
import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.userAccess.dto.UserAccessDTO;
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
import javax.jms.Session;
import org.springframework.jms.JmsException;
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

    @Value("${messages.queue.jmsuserdto}")
    private String queueJmsSendUserDTO;

    @Value("${messages.queue.jmsuseraccessdto}")
    private String queueJmsSendUserAccessDTO;

    @Value("${messages.queue.jmsresetpassword}")
    private String queueJmsResetPassword;
    
    @Value("${messages.queue.jmsregistry}")
    private String queueJmsRegistry;

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
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(personWeatherDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error al crear json para creación de cola  : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(queueJmsSendUser, messageCreator);
        } catch (JmsException e) {
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

    @Override
    public void sendUser(UserDTO userDTO) {
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(userDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error al crear json para creación de cola  : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(queueJmsSendUserDTO, messageCreator);
        } catch (JmsException e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }

    @Override
    public void sendUserAccess(UserAccessDTO userAccessDTO) {
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(userAccessDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error al crear json para creación de cola  : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(queueJmsSendUserAccessDTO, messageCreator);
        } catch (JmsException e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }

    @Override
    public void sendResetPassword(ResetPasswordDTO resetPasswordDTO) {
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(resetPasswordDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error al crear json para creación de cola  : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(queueJmsResetPassword, messageCreator);
        } catch (JmsException e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }
    
    
    @Override
    public void sendRegistry(ResetPasswordDTO resetPasswordDTO) {
        MessageCreator messageCreator = (Session session) -> {
            try {
                String json = mapper.writeValueAsString(resetPasswordDTO);
                return session.createTextMessage(json);
            } catch (JsonProcessingException e) {
                LOG.error(" Error al crear json para creación de cola  : " + e);
            }
            return null;
        };
        try {
            jmsTemplate.send(queueJmsRegistry, messageCreator);
        } catch (JmsException e) {
            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
        }
    }
}
