/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.demo.interfaces.pais.service.impl;

import com.app.demo.domains.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.demo.interfaces.pais.service.PaisService;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("paisService")
public class PaisServiceImpl implements PaisService {

    @Autowired
    PaisRepository paisRepository;

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
