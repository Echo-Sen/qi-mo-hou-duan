package com.olrando.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "olrando";//签名密钥
    private static Long expire = 43200000L; //有效时间

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return 令牌
     */
    public static String generateJwt(Map<String,Object> claims){
        return Jwts.builder().addClaims(claims).signWith(SignatureAlgorithm.HS256,signKey).setExpiration(new Date(System.currentTimeMillis() + expire)).compact();
    }

    /**
     *
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt){
            return Jwts.parser().setSigningKey(signKey).parseClaimsJws(jwt).getBody();
    }
}
