package br.com.marcosvxn.spring_boot_essentials.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${jwt.expiration}")
    private long expirationTime;

    @Value("${jwt.key}")
    private String key;

    // gerar um toker

    public String gerarToken(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return buildToken(user.getUsername());
    }

    private String buildToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationTime);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSingingKey())
                .compact();
    }

    private SecretKey getSingingKey() {
        return Keys.hmacShaKeyFor(key.getBytes());
    }

    // validar um token

    public boolean isTokenValid(String token) {
        try {
            getClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }

    }


    //extrair informacoes do token
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }


    public Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSingingKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
