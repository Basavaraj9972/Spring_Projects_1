package com.tap.utils;
import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class KeyGenerator {
	private static final String SECRET_KEY = "MySuperSecretKey123";  // Use env variable in production
	 private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 30 minutes
    public static void main(String[] args) {
//        SecureRandom random = new SecureRandom();
//        byte[] keyBytes = new byte[64]; // 64 bytes
//        random.nextBytes(keyBytes);
//        String secretKey = Base64.getEncoder().encodeToString(keyBytes);
//        System.out.println("Generated Secret Key: " + secretKey);
//        generateToken("Basavaraj");
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // Create JWT Token
        String token = Jwts.builder()
                .setSubject("Basavaraj")  // User identifier
                .setIssuedAt(new Date())  // Issued time
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) // 30-minute expiration
                .signWith(key)  // Use the secure key
                .compact();

        System.out.println("Generated Token: " + token);
        System.out.println("Secret Key (Base64 Encoded): " + java.util.Base64.getEncoder().encodeToString(key.getEncoded()));

    }
//    private static String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }

}

