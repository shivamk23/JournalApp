package com.companyproject.journalApp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    // Ensure the key is at least 32 characters long (256 bits when using UTF-8 encoding)
    private static final String SECRET_KEY = "hvj2h32j43hvj3h4vl2j3hvvgvjhghg1234567890abcdef";

    private SecretKey getSigningKey() {
        // Use Keys.hmacShaKeyFor to generate a secure key for HS256
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public Date extractExpiration(String token){
        return extractAllClaims(token).getExpiration();
    }

    public String extractClaim(String token,String claim){
        return extractAllClaims(token).get(claim,String.class);
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }


    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1)) // Token validity of 5 minutes
                .signWith(getSigningKey()) // Sign with a secure key
                .compact();
    }
    public boolean validateToken(String token){
        return !isTokenExpired(token);
    }

}
