package com.ssaisriharsha.PersonalCloudStorage.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }
}
