/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.utils;

/**
 *
 * @author Desarrollo3
 */
import com.app.app.domains.user.User;
import com.app.app.interfaces.user.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MethodsUtil {

    public static Object convertObject(Object object) {
        ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();
        Object obj = new Object();
        obj = objectMapper.convertValue(object, Object.class);
        return obj;
    }

    public static User convertObject(UserDTO userDTO, Class<User> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
