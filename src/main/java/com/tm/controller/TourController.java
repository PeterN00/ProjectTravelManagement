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

    public void uploadImgFile(Tour tour) {
        if (tour.getImgFile() != null) {
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
    }

    @GetMapping
    public String tours(Model model,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", defaultValue = "1") Integer page){
        model.addAttribute("tours", tourService.getTours(search, page));
        model.addAttribute("tourcount", tourService.tourCount());
        return "tours";
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

        uploadImgFile(tour);

        tourService.addTour(tour);
        reAttr.addFlashAttribute("msg", "New Tour Added!");
        return "redirect:/tours";
    }

    @GetMapping("/{id}")
    public String tourDetails(@PathVariable("id") Integer id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);
        model.addAttribute("pageTitle", tour.getTitle());
        return "tourdetails";
    }

    @RequestMapping("/{id}/delete")
    public String tourDelete(@PathVariable("id") Integer id, RedirectAttributes reAttr) {
        tourService.deleteTour(id);
        reAttr.addFlashAttribute("msg", "Tour: {id: " + id + "} Deleted!");
        return "redirect:/tours";
    }

    @GetMapping("/{id}/edit")
    public String tourEditView(@PathVariable("id") Integer id, Model model) {
        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);
        model.addAttribute("pageTitle", tour.getTitle());
        return "touredit";
    }

    @PostMapping("/{id}/edit")
    public String tourEditHandler(RedirectAttributes reAttr,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result) {
        System.out.println(tour);
        if (result.hasErrors()) {
            System.out.println(result);
            return "redirect:/";
        }

        uploadImgFile(tour);

        tourService.editTour(tour);
        reAttr.addFlashAttribute("msg", "Tour: {id: " + tour.getId() + "} Edited!");
        return "redirect:/tours/{id}";
    }
}
