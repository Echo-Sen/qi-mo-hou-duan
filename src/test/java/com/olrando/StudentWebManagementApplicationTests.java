package com.olrando;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
//class StudentWebManagementApplicationTests {
//
//    @Test
//    public void testGenJwt() {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("username","Tom");
//        String jwt = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, "orando").setExpiration(new Date(System.currentTimeMillis() +
//                24 * 3600 * 1000)).compact();
//        System.out.println(jwt);
//    }
//    public void parseJwt() {
//        Claims claims = Jwts.parser().setSigningKey("olrando").parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjkyMzYxMTg5LCJ1c2VybmFtZSI6IlRvbSJ9.VFMd7Gs_sCv4XzNsp0__8VufCNkguZ4vsneNNctbNiE").getBody();
//        System.out.println(claims);
//    }
//}
