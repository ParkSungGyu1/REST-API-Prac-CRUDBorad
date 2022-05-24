package com.spring.crudprac.controller;

import com.spring.crudprac.dto.PasswordCheckDto;
import com.spring.crudprac.dto.PostDto;
import com.spring.crudprac.model.Posting;
import com.spring.crudprac.service.PostingService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/post/write")
    public String postwrite(@RequestBody PostDto postDto){
        postingService.postwrite(postDto);
        return "redirect:main";
    }

    @GetMapping("/post/detail")
    public String detailview(@RequestParam Long id, Model model){
        model.addAttribute("list",postingService.getdetail(id));
        return "detail";
    }


    @PostMapping("/post/detail/password")
    @ResponseBody
    public PasswordCheckDto passwordcheck(@RequestBody PasswordCheckDto passwordCheckDto){

        passwordCheckDto.setResult(postingService.passwordcheck(passwordCheckDto.getId(),passwordCheckDto.getPassword()));
        return passwordCheckDto;
    }

    @PutMapping("/post/detail/change")
    @ResponseBody
    public Posting changedetail(@RequestBody Posting posting){
        Posting posting1 = postingService.changedetail(posting);

        return posting1;
    }

    @DeleteMapping("/post/detail/delete")
    @ResponseBody
    public void deletedetail(@RequestBody Posting posting){
        postingService.deletedetail(posting);
    }

}
