package com.app.app.infraestruct;

import com.app.app.domains.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos
 */
@Component
public class AuthUtils {

//    @Value("${authapp.secretkey}")
    private String appSecretKey;

    public String createLoginToken(String host, User user) {
        return Jwts.builder()
                .setSubject(user.userName())
                .claim("id", user.id())
                .setIssuer(host)
                .setIssuedAt(DateTime.now().toDate())
                .signWith(SignatureAlgorithm.HS256, "12347890").compact();
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }
}
