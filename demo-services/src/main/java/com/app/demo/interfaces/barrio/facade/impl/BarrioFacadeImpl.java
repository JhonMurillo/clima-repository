/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.barrio.facade.impl;

import com.app.app.utils.ObjectMapperUtil;
import com.app.demo.domains.barrio.Barrio;
import com.app.demo.interfaces.barrio.dto.BarrioAllDTO;
import com.app.demo.interfaces.barrio.dto.BarrioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.app.demo.interfaces.barrio.facade.BarrioFacade;
import com.app.demo.interfaces.barrio.service.BarrioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("barrioFacade")
@Transactional
public class BarrioFacadeImpl implements BarrioFacade {

    @Autowired
    BarrioService barrioService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<BarrioDTO> findAll() {
        List<Barrio> listaBarrio = barrioService.findAll();
        if (listaBarrio.isEmpty()) {
            return new ArrayList<>();
        }

        List<BarrioDTO> listaBarrioDTO = new ArrayList<>();
        listaBarrio.stream().map((barrio) -> {
            BarrioDTO barrioDTO = new BarrioDTO();
            barrioDTO.setId(barrio.id());
            barrioDTO.setCodigo(barrio.codigo());
            barrioDTO.setEstado(barrio.estado());
            barrioDTO.setIdCiudad(barrio.idCiudad().id());
            barrioDTO.setNombre(barrio.nombre());
            return barrioDTO;
        }).forEachOrdered((barrioDTO) -> {
            listaBarrioDTO.add(barrioDTO);
        });

        return listaBarrioDTO;
    }

    @Override
    public List<BarrioAllDTO> findInfoAll() {
        return  barrioService.findInfoAll();
    }

//    @Override
//    public UserDTO findByUserName(String userName) {
//        User user = userRepository.findByUserName(userName);
//        if (user == null) {
//            return null;
//        }
//        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);
//        return userDTO;
//    }
//
//    @Override
//    public UserDTO findById(Integer id) {
//        User user = userRepository.findOne(id);
//        if (user == null) {
//            return null;
//        }
//        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);
//        return userDTO;
//    }
//
//    @Override
//    public List<UserDTO> findAll() {
//        try {
//            List<User> listaUser = (List<User>) userRepository.findAll();
//            if (listaUser == null) {
//                return null;
//            }
//            List<UserDTO> listaUserDTO = new ArrayList<>();
//
//            listaUser.stream().map((user) -> {
//                UserDTO userDTO = new UserDTO();
//                userDTO.setId(user.id());
//                userDTO.setPassword(user.password());
//                userDTO.setUserName(user.userName());
//                return userDTO;
//            }).forEachOrdered((userDTO) -> {
//                listaUserDTO.add(userDTO);
//            });
//            return listaUserDTO;
//        } catch (Exception ex) {
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public ResponseUtil registrarUser(UserDTO userDTO) {
//        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            userDTO.setPassword(Encrytacion.getMd5(userDTO.getPassword()));
//            User user = objectMapper.convertValue(userDTO, User.class);
//            userRepository.save(user);
//            userDTO = objectMapper.convertValue(user, UserDTO.class);
//            responseUtil.setTipo(ConstanteUtil.CODE_OK);
//            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
//            responseUtil.setObject(userDTO);
//            return responseUtil;
//        } catch (IllegalArgumentException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            Logger.getLogger(BarrioFacadeImpl.class.getName()).log(Level.SEVERE, null, e);
//        } catch (DataIntegrityViolationException da) {
////            da.printStackTrace();
//            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
//            responseUtil.setMessage("Ya existe un funcionario con este usuario.");
//            return responseUtil;
//        }
//        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
//        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
//        return responseUtil;
//    }
//
//    @Override
//    public ResponseUtil eliminarUser(Integer id) {
//        ResponseUtil responseUtil = new ResponseUtil();
//        try {
//            userRepository.delete(id);
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
}
