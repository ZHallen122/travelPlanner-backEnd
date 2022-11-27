package com.travelplanner.travelplannerbackend;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import io.jsonwebtoken.security.Keys;
import javax.sql.DataSource;
import java.security.Key;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password FROM User WHERE email=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }

   // @Bean
   // public PassWordEncoder passwordEncoder(){
  //      return new BCryptPasswordEncoder();
  //  }











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
