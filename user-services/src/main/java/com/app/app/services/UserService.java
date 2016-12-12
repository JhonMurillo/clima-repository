package com.app.app.services;

import com.app.app.model.dtos.UserDTO;
import com.app.app.utils.ResponseUtil;
import java.util.List;

public interface UserService {

    UserDTO findByUserName(String userName);

    UserDTO findById(Integer id);

    List<UserDTO> findAll();

    ResponseUtil registrarUser(UserDTO userDTO);

    ResponseUtil eliminarUser(Integer id);
}
