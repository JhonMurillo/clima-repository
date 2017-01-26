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
import com.fasterxml.jackson.databind.ObjectMapper;

public class MethodsUtil {

    /**
     *
     * @param <T>
     * @param t
     * @return
     */
    public static <T> T convertObject(T t) {
        ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

        T obj = null;
        obj = objectMapper.convertValue(t, (Class<T>) t.getClass());
        return obj;
    }

}
