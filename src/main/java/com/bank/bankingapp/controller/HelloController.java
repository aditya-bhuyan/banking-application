package com.bank.bankingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class HelloController {

    @GetMapping("/")
    public String hello() {
        System.out.println("Accessing /hello endpoint");
        return "hello";  // This should map to src/main/resources/templates/hello.html
    }
}