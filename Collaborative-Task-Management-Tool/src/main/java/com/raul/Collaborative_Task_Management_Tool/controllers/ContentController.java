package com.raul.Collaborative_Task_Management_Tool.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class ContentController {

    @GetMapping("/login")
    public String login(){
        return "login"; // name of html
    }

    @GetMapping("/req/signup")
    public String signup(){
        return "signup";
    }
}
