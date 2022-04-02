/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.pojo.Tour;
import com.tm.service.TourService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PHUC
 */
@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    private TourService tourService;
    
    @GetMapping("")
    public String index(Model model,
            @RequestParam(name = "toursearch", required = false) String search,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        model.addAttribute("tours", this.tourService.getTours(search, page));
        model.addAttribute("tourcount", tourService.tourCount());
        return "index";
    }

    @GetMapping("/add")
    public String newTourView(Model model) {
        model.addAttribute("tour", new Tour());
        return "newtour";
    }

    @PostMapping("/add")
    public String newTourHandler(Model model,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result) {
        if (result.hasErrors()) {
            return "newtour";
        }

        tourService.addTour(tour);
        String msg = "New Tour Added!";
        model.addAttribute("msg", msg);

        return "newtour";
    }
}
