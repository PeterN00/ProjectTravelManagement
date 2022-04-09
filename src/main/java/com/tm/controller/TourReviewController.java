/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.pojo.TourReview;
import com.tm.service.TourReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PHUC
 */
@Controller
@RequestMapping("/tours")
public class TourReviewController {
    @Autowired
    private TourReviewService tourReviewService;
    
    @PostMapping("/{id}/review")
    public String reviewHandler(@PathVariable("id") Integer id,
            @RequestParam(name = "rating", defaultValue = "0") String rate,
            @ModelAttribute(value = "review") TourReview review){
        
        tourReviewService.review(review, id, rate);
        return "redirect:/tours/{id}";
    }
    
}
