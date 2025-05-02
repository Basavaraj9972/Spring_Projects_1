package com.tap;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class GenerateToken {

	public static void main(String[] args) {
//		 // Generate a secure secret key (HS256 requires 256-bit key)
//        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        System.out.print(secretKey);
//
//        // Generate JWT token
//        String jwtToken = Jwts.builder()
//                .setSubject("Basavaraj") // Example subject (username)
//                .setIssuer("MyApp") // Issuer name
//                .setIssuedAt(new Date()) // Token issued date
//                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Expire in 1 hour
//                .signWith(secretKey) // Signing with the generated secret key
//                .compact();
//
//        System.out.println("Generated Token: " + jwtToken);
//        System.out.println("Secret Key (Base64 Encoded): " + java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded()));
		String storedKey = null;
		// Retrieve from System property (for signing JWT)
		storedKey = System.getProperty("JWT_SECRET");
		if(storedKey == null) {
			// Generate a dynamic secret key
			Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			
			// Convert secret key to Base64 (for storage or sharing)
			String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
			
			// Store in System environment (Runtime)
			System.setProperty("JWT_SECRET", encodedKey);
		}
		        
				storedKey = System.getProperty("JWT_SECRET");
		        Key retrievedKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(storedKey));

		        // Generate JWT Token using the dynamically set key
		        String jwtToken = Jwts.builder()
		                .setSubject("Basavaraj")
		                .setIssuer("MyApp")
		                .setIssuedAt(new Date())
		                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiry
		                .signWith(retrievedKey, SignatureAlgorithm.HS256)
		                .compact();

//		        System.out.println("Dynamically Generated Secret Key (Base64): " + encodedKey);
		        System.out.println("Generated JWT Token: " + jwtToken);
	
	}

}

//


//
