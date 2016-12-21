/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.utils;

import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public enum RestrictionDB {

    UK_EMAIL_PERSON("uk_email_person"),
    UK_USER_USER("uk_user_name_user");

    /**
     * Llave para el archivo de propiedades a internacionalizar
     */
    private final String keyMensaje;

    private RestrictionDB(String keyMensaje) {
        this.keyMensaje = keyMensaje;
    }

    /**
     * @return the keyMensaje
     */
    public String getKeyMensaje() {
        return keyMensaje;
    }

    public String findRestriction(String detailMessage, List<String> excepciones) {
        for (String excepcion : excepciones) {
            if (detailMessage.contains(excepcion)) {
//                return Messages
                break;
            }
        }
        return null;
    }

    private RestrictionDB() {
        this.keyMensaje = null;
    }

}

class Messages {

    public static final String UK_EMAIL_PERSON = "Email Ya Se Encuentra Registrado.";
    public static final String MSG_FALLIDO = "OPERACIÓN FALLIDA.";
    public static final String CODIGO_EXISTE = "CÓDIGO EXISTE.";
}
