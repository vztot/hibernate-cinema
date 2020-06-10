package com.vztot.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String sayHello() {
        return "<iframe width=\"1024\" height=\"768\"\n"
                + "title=\"Bee Gees - Stayin' Alive\""
                + "src=\"https://www.youtube.com/embed/fNFzfwLM72c\">\n"
                + "</iframe>";
    }
}
