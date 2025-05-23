package com.bookseats.utils;

import ch.qos.logback.core.net.SyslogOutputStream;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtils {

    private static final long EXPIRATION_TIME = 10 * 60 * 60 * 100L;
    private final SecretKey key;


    public JwtUtils() {
        String secretString = "435942b80e82eac40c0bb5c1c0e396535f9d06642ed92d0beaf0fd76cde280147f66045d0d453d90ebeb3b9d30804267c09bb0b05e65f7dec5b96160870fb5c6";
        
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));

        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {

        try {
            return claimsTFunction.apply(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload());
        } catch (Exception e) {
            return null;
        }

    }

    public boolean isValidToken(String token, UserDetails userDetails) {

        try {
            final String username = extractUsername(token);
            return username != null && username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        } catch (Exception e) {
            System.out.println("Invalid token " + e.getMessage());
            return false;
        }


    }

    private boolean isTokenExpired(String token) {

        try {
            return extractClaims(token, Claims::getExpiration).before(new Date());
        } catch (Exception e) {
            return true;
        }

    }
}
