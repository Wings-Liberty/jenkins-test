package com.cx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class TestController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}