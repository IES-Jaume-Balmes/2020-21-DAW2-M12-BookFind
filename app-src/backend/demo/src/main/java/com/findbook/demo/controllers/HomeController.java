package com.findbook.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {


    @RequestMapping
    public String getHome() {


        return "loged";
    }


}
