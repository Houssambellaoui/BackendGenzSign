package com.prod.GenZ.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "404D635166546A576E5A7234743777217A25432A462D4A614E645267556B5870";
    private final Set<String> blacklistedTokens = new HashSet<>();

    public String extractLogin(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(
            UserDetails userDetails,
            Integer expireAfterHours){
        return generateToken(new HashMap<>(), userDetails, expireAfterHours);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            Integer expireAfterHours
    ){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * expireAfterHours)))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Boolean isTokenValid(String token, UserDetails userDetails){
        final String login = extractLogin(token);
        return (login.equals(userDetails.getUsername())) &&
                !isTokenExpired(token) &&
                !isTokenBlacklisted(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public void blacklistToken(String token) {
        blacklistedTokens.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

    public void logout(String token) {
        blacklistToken(token);
        // Additional logic, if needed, such as removing the token from an active session or updating the user's status.
    }

}
