/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.utils;

/**
 *
 * @author DESARROLLO
 */

import org.springframework.http.HttpStatus;

public class ConstanteUtil {

    /**
     *
     * CODIGOS DE RESPUESTA
     */
    public static final int CODE_OK = HttpStatus.OK.value();
    public static final int CODE_ERROR = HttpStatus.CONFLICT.value();
    public static final int CODE_INTERNAL_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();

    /**
     * MSG - GENERALES
     */
    public static final String MSG_EXITO = "OPERACIÓN EXITOSA.";
    public static final String MSG_FALLIDO = "OPERACIÓN FALLIDA.";
    public static final String CODIGO_EXISTE = "CÓDIGO EXISTE.";
    
    /**
     * ESTADO
     */
    public static final String ACTIVO = "ACTIVO";
    public static final String INACTIVO = "INACTIVO";
}