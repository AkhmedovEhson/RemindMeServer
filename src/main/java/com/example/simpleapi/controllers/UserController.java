package com.example.simpleapi.controllers;


import com.example.simpleapi.models.Auth;
import com.example.simpleapi.token.Token;
import com.example.simpleapi.token.TokenHandler;
import org.springframework.web.bind.annotation.*;

@RestController
public class user_controller {

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String Login(Auth auth)
    {
        var token = new Token();
        var tokenHandler = new TokenHandler();
        token.Id = 1;
        token.Username = auth.Username;
        token.Age = 18;


        return tokenHandler.generateToken(token);
    }
}
