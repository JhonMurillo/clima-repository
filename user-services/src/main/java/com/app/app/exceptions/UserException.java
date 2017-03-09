/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.app.exceptions;

/**
 *
 * @author DESARROLLO
 */
public class UserException extends Exception {

    public UserException(String string) {
        super(string);
    }

    public UserException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
    public UserException(Throwable thrwbl) {
        super(thrwbl);
    }

}
