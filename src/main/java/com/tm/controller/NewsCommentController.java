/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.pojo.NewsComment;
import com.tm.service.NewsCommentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PHUC
 */
@Controller
@RequestMapping("/news")
public class NewsCommentController {
    @Autowired
    private NewsCommentService newsCommentService;
    
    @PostMapping("/{id}/comment")
    public String comment(@PathVariable("id") Integer id, 
            @ModelAttribute(name = "comment") @Valid NewsComment comment,
            BindingResult result){
        
        if(result.hasErrors()){
            System.out.println(result);
            return "redirect:/news/{id}";
        }
        
        newsCommentService.comment(comment, id);
        return "redirect:/news/{id}";
    }
    
}
