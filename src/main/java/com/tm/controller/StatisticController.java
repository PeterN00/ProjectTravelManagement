/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/statistics")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;
    
    @GetMapping
    public String statistics(){
        return "statistics";
    }
    
    @GetMapping("/bookingcount")
    public String bookingCountView(Model model, @RequestParam(name = "limit", defaultValue = "5") int limit){
        model.addAttribute("statistic", statisticService.tourBookingCount(limit));
        return "bookingcountstatistic";
    }
    
    @PostMapping("/bookingcount")
    public String bookingCountLimitHandler(Model model, @RequestParam(name = "limit", defaultValue = "5") int limit){
        model.addAttribute("statistic", statisticService.tourBookingCount(limit));
        model.addAttribute("selectedLimit", limit);
        return "bookingcountstatistic";
    }
}
