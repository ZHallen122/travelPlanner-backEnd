package com.travelplanner.travelplannerbackend;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
import java.security.Key;


public class SecurityConfig {

    //creat key
    //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();

    //verify
//    try {
//
//        Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(compactJws);
//
//        //OK, we can trust this JWT
//
//    } catch (
//    JwtException e) {
//
//        //don't trust the JWT!
//    }
}
