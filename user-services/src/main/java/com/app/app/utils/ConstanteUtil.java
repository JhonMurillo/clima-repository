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
     * CODES OF ANSWERS
     */
    public static final int CODE_OK = HttpStatus.OK.value();
    public static final int CODE_ERROR = HttpStatus.CONFLICT.value();
    public static final int CODE_INTERNAL_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final int CODE_UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();
    public static final int CODE_FORBIDDEN = HttpStatus.FORBIDDEN.value();
    public static final Integer CODE_BAD_REQUEST = HttpStatus.BAD_REQUEST.value();

    /**
     * MSG - GENERALES
     */
    public static final String MSG_EXITO = "OPERACIÓN EXITOSA.";
    public static final String MSG_FALLIDO = "OPERACIÓN FALLIDA.";
    public static final String CODIGO_EXISTE = "CÓDIGO EXISTE.";

    /**
     * MSG - AUTH
     */
    public static final String MSG_AUTORIZACION = "NO AUTORIZADO!!";
    public static final String MSG_NO_AUTORIZACION = "NO AUTORIZADO!!";
    public static final String MSG_ERROR_AUTENTICACION = "ERROR AL AUTENTICAR";
    public static final String MSG_USER_NO_EXISTE = "USUARIO NO EXISTE.";
    public static final String MSG_PASS_NO_VALIDAD = "CONTRASEÑA INCORRECTA";
    public static final String MSG_NO_ACCESS = "USUARIO NO POSEE ACCESO AL SISTEMA";

    /**
     * STATES
     */
    public static final Character STATE_ACTIVO = 'A';
    public static final Character STATE_INACTIVO = 'I';
}
