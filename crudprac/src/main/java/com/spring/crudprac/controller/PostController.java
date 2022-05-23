package com.spring.crudprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @GetMapping("/")
    public String mainview(){
        return "main";
    }

    @GetMapping("/detail")
    public String detailview(){
        return "detail";
    }



}
