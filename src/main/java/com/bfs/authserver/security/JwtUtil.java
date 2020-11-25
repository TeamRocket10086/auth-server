package com.bfs.authserver.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {

    public static String generateToken(String signingKey, String subject, String email, Integer personID, String createDate, String modificationDate, String roleName) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .claim("email", email)
                .claim("personID", personID)
                .claim("createDate", createDate)
                .claim("modificationDate", modificationDate)
                .claim("roleName", roleName)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }
    //test register
    public static String generateRegisterToken(String signingKey, String subject, String email) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .claim("email", email)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, signingKey);

        return builder.compact();
    }

    public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) return null;
        System.out.println(Jwts.parser().setSigningKey(signingKey));
        System.out.println(Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token));
        System.out.println(Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody());

        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody().getSubject();
    }
}
