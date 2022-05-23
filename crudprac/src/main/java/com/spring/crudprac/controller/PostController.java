package com.spring.crudprac.controller;

import com.spring.crudprac.dto.PostDto;
import com.spring.crudprac.model.Posting;
import com.spring.crudprac.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PostController {

    private final PostingService postingService;

    @Autowired
    public PostController(PostingService postingService){
        this.postingService = postingService;
    }

    @GetMapping("/")
    public String mainview(Model model){

        List<Posting> posts = postingService.postview();
        model.addAttribute("posts",posts);

        return "main";
    }

    @GetMapping("/detail")
    public String detailview(){
        return "detail";
    }

    @PostMapping("/post/write")
    public String postwrite(@RequestBody PostDto postDto){
        postingService.postwrite(postDto);
        return "redirect:main";
    }


}
