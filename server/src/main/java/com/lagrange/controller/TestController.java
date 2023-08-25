package com.lagrange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class TestController {

    @GetMapping("api/test")
    public String test(){
        return "Wesh";
    }
}
