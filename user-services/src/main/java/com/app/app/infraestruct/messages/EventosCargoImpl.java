package com.app.app.infraestruct.messages;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.app.app.infraestruct.mensajes;
//
//import co.agileventure.cloud.authorization.interfaces.cargo.facade.CargoServiceFacade;
//import co.agileventure.cloud.authorization.interfaces.cargo.facade.EventosCargo;
//import co.agileventure.cloud.authorization.interfaces.cargo.facade.dto.CargoDTO;
//import co.agileventure.cloud.authorization.utilidades.ObjectMapperUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author DESARROLLO 13
// */
//@Component
//public class EventosCargoImpl implements EventosCargo {
//    
//    public final static Logger LOG = LoggerFactory.getLogger(EventosCargoImpl.class);
//    
//    @Autowired
//    JmsTemplate jmsTemplate;
//    
//    @Autowired
//    private CargoServiceFacade cargoServiceFacade;
//    
//    ObjectMapper mapper = ObjectMapperUtil.getInstanceObjectMapper();
//    
//    @JmsListener(destination = "${mensajes.queue.eventoscargo}")
//    @Override
//    public void cargoCreado(String cargo) {
//        try {
//            CargoDTO cargoDTO = mapper.convertValue(mapper.readTree(cargo), CargoDTO.class);
//            cargoServiceFacade.guardarCargo(cargoDTO);
//        } catch (IOException | IllegalArgumentException e) {
//            LOG.error("Error : " + e);
//        }
//    }
//}
