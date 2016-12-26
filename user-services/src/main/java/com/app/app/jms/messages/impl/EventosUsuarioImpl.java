package com.app.app.jms.messages.impl;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.app.app.infraestruct.messages;
//
//import co.agileventure.cloud.authorization.interfaces.usuario.facade.dto.UsuarioCajeroDTO;
//import co.agileventure.cloud.authorization.interfaces.usuariorol.EventosUsuarioRol;
//import co.agileventure.cloud.authorization.utilidades.ObjectMapperUtil;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author DESARROLLO 13
// */
//@Component
//public class EventosUsuarioImpl implements EventosUsuarioRol {
//
//    public final static Logger LOG = LoggerFactory.getLogger(EventosUsuarioImpl.class);
//
//    @Autowired
//    JmsTemplate jmsTemplate;
//
//    @Value("${mensajes.queue.eventosusuariorolcajero}")
//    private String queueEventosUsuarioRolCajero;
//
//    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();
//
//    @Override
//    public void enviarUsuarioRolCajero(UsuarioCajeroDTO usuarioCajetoDTO) {
//        MessageCreator messageCreator = new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                try {
//                    String json = mapper.writeValueAsString(usuarioCajetoDTO);
//                    return session.createTextMessage(json);
//                } catch (JsonProcessingException e) {
//                    LOG.error(" Error al crear json para creación de cola  : " + e);
//                }
//                return null;
//            }
//        };
//        try {
//            jmsTemplate.send(queueEventosUsuarioRolCajero, messageCreator);
//        } catch (Exception e) {
//            LOG.error("Error al enviar la cola de mensajes a usuario financiero  :" + e);
//        }
//    }
//}
