/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.interfaces.user.facade.impl;

import com.app.app.interfaces.user.dto.UserDTO;
import com.app.app.interfaces.user.facade.UserFacade;
import com.app.app.interfaces.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.springframework.stereotype.Component;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;

/**
 *
 * @author DESARROLLO
 */
@Component("UserFacade")
@Transactional
public class UserFacadeImpl implements UserFacade {

    @Autowired
    UserService userService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<UserDTO> findAll() {
        return null;
//        return convertListDTO(userService.findAll());
    }

//    @Override
//    public List<BarrioAllDTO> findInfoAll() {
//
//        String json = barrioService.findInfoAll();
//        if (json == null) {
//            return new ArrayList<>();
//        }
//        try {
//            return objectMapper.readValue(json, new TypeReference<List<BarrioAllDTO>>() {
//            });
//        } catch (IOException ex) {
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    @Override
//    public BarrioDTO findByBarrioName(String barrioName) {
//        Barrio barrio = barrioRepository.findByBarrioName(barrioName);
//        if (barrio == null) {
//            return null;
//        }
//        BarrioDTO barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
//        return barrioDTO;
//    }
//
//    @Override
//    public BarrioDTO findById(Integer id) {
//        Barrio barrio = barrioRepository.findOne(id);
//        if (barrio == null) {
//            return null;
//        }
//        BarrioDTO barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
//        return barrioDTO;
//    }
//
//    @Override
//    public List<BarrioDTO> findAll() {
//        try {
//            List<Barrio> listaBarrio = (List<Barrio>) barrioRepository.findAll();
//            if (listaBarrio == null) {
//                return null;
//            }
//            List<BarrioDTO> listaBarrioDTO = new ArrayList<>();
//
//            listaBarrio.stream().map((barrio) -> {
//                BarrioDTO barrioDTO = new BarrioDTO();
//                barrioDTO.setId(barrio.id());
//                barrioDTO.setPassword(barrio.password());
//                barrioDTO.setBarrioName(barrio.barrioName());
//                return barrioDTO;
//            }).forEachOrdered((barrioDTO) -> {
//                listaBarrioDTO.add(barrioDTO);
//            });
//            return listaBarrioDTO;
//        } catch (Exception ex) {
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public ResponseUtil eliminarBarrio(Integer id) {
//        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            barrioRepository.delete(id);
//            responseUtil.setTipo(ConstanteUtil.CODE_OK);
//            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
//            return responseUtil;
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
//        } catch (DataIntegrityViolationException da) {
//            da.printStackTrace();
//            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
//            responseUtil.setMessage("El usuario esta siendo utilizado.");
//            return responseUtil;
//        }
//        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
//        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
//        return responseUtil;
//    }
    @Override
    public ResponseUtil saveUser(UserDTO userDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            Barrio barrio = objectMapper.convertValue(barrioDTO, Barrio.class);
//            barrioService.save(barrio);
//            barrioDTO = objectMapper.convertValue(barrio, BarrioDTO.class);
//            responseUtil.setTipo(ConstanteUtil.CODE_OK);
//            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
//            responseUtil.setObject(barrioDTO);
////            responseUtil.setObjectResponse(barrioDTO);
//            return responseUtil;
//        } catch (IllegalArgumentException | PropertyAccessException p) {
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
//        } catch (DataIntegrityViolationException da) {
//            responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
//            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
//            return responseUtil;
//        }
//        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
//        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public UserDTO findById(Long id) {
        UserDTO userDTO = objectMapper.convertValue(userService.findById(id), UserDTO.class);
        return userDTO;
    }

}
