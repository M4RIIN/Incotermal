package com.lagrange;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "/**/{path:[^.]*}")
    public String redirect() {
        // Forward to home page so that route is preserved.(i.e forward:/intex.html)
        return "forward:/";
    }
}