package com.app.app.infraestruct;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Carlos
 */
public final class PasswordService {

    public static String hashPassword(String plaintext) {
        return BCrypt.hashpw(plaintext, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plaintext, String hashed) {
        return BCrypt.checkpw(plaintext, hashed);
    }

    public static boolean equalsPassword(String passwordIn, String passwordStorage) {
        try {
            passwordIn = com.app.app.utils.Encrytacion.getMd5(passwordIn);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Objects.equals(passwordIn, passwordStorage);
    }
}
