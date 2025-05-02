package com.tap.utils;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
    private static final String SECRET_KEY = "CQXxQ4tE3KXV+7+SH7RWNgzy4TjFnNMhb+mHu6uhvIw="; // Change this to a more secure key
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public static String validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
