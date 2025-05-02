package com.tap.utils;


import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
//    private static final String SECRET_KEY = "CQXxQ4tE3KXV+7+SH7RWNgzy4TjFnNMhb+mHu6uhvIw="; // Replace with a secure secret key
//
//    // Generate JWT token
//    public static String generateToken(String loginId) {
//        return Jwts.builder()
//                .setSubject(loginId)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }

    
    
    private static final String SECRET_KEY = "CQXxQ4tE3KXV+7+SH7RWNgzy4TjFnNMhb+mHu6uhvIw="; // Change this to your actual secret key

    public static String generateToken(String loginId) {
        return Jwts.builder()
                .setSubject(loginId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    
    
    
    
    
    // Validate and extract claims from JWT token
    public static Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
