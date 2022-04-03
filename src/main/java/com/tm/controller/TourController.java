/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tm.pojo.Tour;
import com.tm.service.TourService;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author PHUC
 */
@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private Cloudinary cloudinary;
    
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
    public String newTourHandler(
            @ModelAttribute(value = "tour") @Valid Tour tour,
            RedirectAttributes reAttr,
            BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "newtour";
        }
        
        if(tour.getImgFile() != null){
            try {
                Map res = cloudinary.uploader().upload(tour.getImgFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto", 
                                "folder", "travelmanagementproject_tourimg"
                        ));
                tour.setImg((String) res.get("secure_url"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
        }
        
        tourService.addTour(tour);
        reAttr.addFlashAttribute("msg", "New tour added!");
        return "redirect:/tours";
    }
    
    @GetMapping("/{id}")
    public String tourDetails(@PathVariable("id") Integer id, Model model){
        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);
        model.addAttribute("pageTitle", tour.getTitle());
        return "tourdetails";
    }
    
    @RequestMapping("/{id}/delete")
    public String tourDelete(@PathVariable("id") Integer id, RedirectAttributes reAttr){
        tourService.deleteTour(id);
        reAttr.addFlashAttribute("msg", "Tour: {id: "+id+"} deleted!");
        return "redirect:/";
    }
}
