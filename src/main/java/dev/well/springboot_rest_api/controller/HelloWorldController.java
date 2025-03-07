package dev.well.springboot_rest_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HelloWorldController {

    //HTTP GET REQUEST
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}
