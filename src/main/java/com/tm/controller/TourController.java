/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PHUC
 */
@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    
    @RequestMapping("/Tours")
    public String index(Model model, 
            @RequestParam(name="toursearch", required = false) String search, 
            @RequestParam(name="page", defaultValue = "1") Integer page){
        model.addAttribute("tours", this.tourService.getTours(search, page));
        model.addAttribute("tourcount", tourService.tourCount());
        return "index";
    }
}
