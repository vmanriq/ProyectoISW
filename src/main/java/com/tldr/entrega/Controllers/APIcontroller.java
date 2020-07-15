package com.tldr.entrega.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class APIcontroller {
    
    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
