package com.example.simpleapi.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.sound.sampled.AudioFormat;
import java.beans.Encoder;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
public class TokenHandler {
    public String SecretKey = "aGVsbG93b3JkdGhpc2lzbXlzZWNyZXRrZXl5b3VzaG91bGRub3RyZWFkaXRpdGlzYXNlY3JldA==";

    public String generateToken(Token token)
    {
        var claims = new HashMap<String,Object>();
        claims.put("id",token.Id);
        claims.put("username",token.Username);
        claims.put("age",token.Age);

        String result = Jwts.builder().setClaims(claims).setSubject("Auth")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256,SecretKey).compact();

        return result;
    }

    public Boolean isValid(String token)
    {
        var _token = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token).getBody();

        if (_token.isEmpty())
        {
            return false;
        }

        return !_token.getExpiration().before(new Date());
    }
}
