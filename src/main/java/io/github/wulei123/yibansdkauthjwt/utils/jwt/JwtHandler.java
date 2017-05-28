package io.github.wulei123.yibansdkauthjwt.utils.jwt;


import io.github.wulei123.yibansdkauthjwt.template.JwtMessageTemplate;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;

/**
 * Created by 武雷 on 2017/5/25.
 */

public class JwtHandler{
    public static String jwtCompact(JwtMessageTemplate jwtMessage, String secret){
        byte[] signingKey = DatatypeConverter.parseBase64Binary(secret);
        String compactedJwt = Jwts.builder()
                .setHeaderParam("alg","HS256")
                .setHeaderParam("typ","JWT")
                .claim("userid",jwtMessage.getUserid())
                .claim("username",jwtMessage.getUsername())
                .claim("usernick",jwtMessage.getUsernick())
                .claim("usersex",jwtMessage.getUsersex())
                .claim("islogin",jwtMessage.getIslogin())
                .claim("ybhead",jwtMessage.getYbhead())
                .claim("expiration",jwtMessage.getExpiration())
                .claim("isadmin",jwtMessage.getIsadmin())
                .setSubject("YiBan")
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();
        return compactedJwt;
    }
    public static String jwtCompact(HashMap<String,Object> jwtMessage, String secret){
        byte[] signingKey = DatatypeConverter.parseBase64Binary(secret);
        String compactedJwt = Jwts.builder()
                .setHeaderParam("alg","HS256")
                .setHeaderParam("typ","JWT")
                .setClaims(jwtMessage)
                .setSubject("YiBan")
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();
        return compactedJwt;
    }
    public static String  jwtCompact(Jws<Claims> jwtMessage,String secret) {
        byte[] signingKey = DatatypeConverter.parseBase64Binary(secret);
        String compactedJwt = Jwts.builder()
                .setHeaderParam("alg","HS256")
                .setHeaderParam("typ","JWT")
                .setClaims(jwtMessage.getBody())
                .setSubject("YiBan")
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact();
        return compactedJwt;
    }
    public static Jws<Claims> jwtParser(String compactedJwt, String secret) {
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(compactedJwt);
    }
}
