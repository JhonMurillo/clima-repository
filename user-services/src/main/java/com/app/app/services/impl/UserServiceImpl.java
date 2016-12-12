package com.app.app.services.impl;

import com.app.app.model.User;
import com.app.app.model.dtos.UserDTO;
import com.app.app.model.repositories.UserRepository;
import com.app.app.services.UserService;
import com.app.app.utils.ConstanteUtil;
import com.app.app.utils.ObjectMapperUtil;
import com.app.app.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.app.app.utils.Encrytacion;
import java.security.NoSuchAlgorithmException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

@Component("userService")
//@Transactional
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public UserDTO findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO findById(Integer id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = objectMapper.convertValue(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {
        try {
            List<User> listaUser = (List<User>) userRepository.findAll();
            if (listaUser == null) {
                return null;
            }
            List<UserDTO> listaUserDTO = new ArrayList<>();

            listaUser.stream().map((user) -> {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.id());
                userDTO.setPassword(user.password());
                userDTO.setUserName(user.userName());
                return userDTO;
            }).forEachOrdered((userDTO) -> {
                listaUserDTO.add(userDTO);
            });
            return listaUserDTO;
        } catch (Exception ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResponseUtil registrarUser(UserDTO userDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            userDTO.setPassword(Encrytacion.getMd5(userDTO.getPassword()));
            User user = objectMapper.convertValue(userDTO, User.class);
            userRepository.save(user);
            userDTO = objectMapper.convertValue(user, UserDTO.class);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(userDTO);
            return responseUtil;
        } catch (IllegalArgumentException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        } catch (DataIntegrityViolationException da) {
//            da.printStackTrace();
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            responseUtil.setMessage("Ya existe un funcionario con este usuario.");
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public ResponseUtil eliminarUser(Integer id) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            userRepository.delete(id);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            return responseUtil;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        } catch (DataIntegrityViolationException da) {
            da.printStackTrace();
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            responseUtil.setMessage("El usuario esta siendo utilizado.");
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }
}
