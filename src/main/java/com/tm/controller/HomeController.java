/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.service.TourService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PHUC
 */
@Controller
public class HomeController {
    @Autowired
    private TourService tourService;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "pricerange", required = false, defaultValue = "1") String priceRange,
            @RequestParam(name = "fromdate", required = false) String fromDate,
            @RequestParam(name = "todate", required = false) String toDate,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        
        model.addAttribute("tours", tourService.getTours(search, page, priceRange, fromDate, toDate));
        model.addAttribute("tourcount", tourService.tourCount());
        model.addAttribute("highestprice", tourService.getHighestPrice());
        
        request.getSession().setAttribute("currentPage", "/ProjectTravelManagement/");
        return "index";
    }
}
