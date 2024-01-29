package com.example.simpleapi.controllers;


import com.example.simpleapi.models.Auth;
import com.example.simpleapi.token.Token;
import com.example.simpleapi.token.TokenHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class user_controller {

    @RequestMapping(value = "/user/login",method = RequestMethod.GET)
    public String Login()
    {
        var token = new Token();
        var tokenHandler = new TokenHandler();
        token.Id = 1;
        token.Username = "Ehson";
        token.Age = 18;

        return tokenHandler.generateToken(token);
    }
}
