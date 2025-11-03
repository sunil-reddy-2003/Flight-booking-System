package com.fbs.central_api.utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthUtility {

    @Value("${jwt.expiration.time}")
    long expirationTime;

    @Value("${jwt.secret.password}")
    String secretPassword;

    /*
    session live on server  --  token live on client
     */

    //JWT token--> header+payload+signature(algorithm and password)
    public String generateToken(String email,
                                String password,
                                String role){

        String payload = email + ":" + password + ":" + role;
        String jwtToken= Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,secretPassword)
                .setSubject(payload)
                .compact();
        return jwtToken;
    }

    public String decryptJwtToken(String token){
        String payload = Jwts.parser().setSigningKey(secretPassword)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return payload;
    }
}
