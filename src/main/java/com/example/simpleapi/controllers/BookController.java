package com.example.simpleapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Book_Controller
{
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public int Get()
    {
        System.out.println("Got value !");
        return 1;
    }
}