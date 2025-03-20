package com.example.messagingredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class HelloworldController {

    @GetMapping("/helloworld")
    public String helloworld() {
        System.out.println("helloworld");
        return "helloworld";
    }


}