/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tm.pojo.Booking;
import com.tm.pojo.Tour;
import com.tm.pojo.TourHighlight;
import com.tm.pojo.TourReview;
import com.tm.service.BookingService;
import com.tm.service.TicketTypeService;
import com.tm.service.TourHighlightService;
import com.tm.service.TourReviewService;
import com.tm.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
    private BookingService bookingSerivce;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private TourReviewService tourReviewService;
    @Autowired
    private TourHighlightService tourHighlightService;
    @Autowired
    private Cloudinary cloudinary;

    public void uploadImgFile(Tour tour) {
        if (!tour.getImgFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(tour.getImgFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto",
                                "folder", "travelmanagementproject_tourimg",
                                "public_id", tour.getImgFile().getOriginalFilename()
                        ));
                tour.setImg((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @GetMapping
    public String tours(Model model, HttpServletRequest request,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", defaultValue = "1") Integer page){
        
        model.addAttribute("tours", tourService.getTours(search, page));
        model.addAttribute("tourcount", tourService.tourCount());
        request.getSession().setAttribute("currentPage", "tours");
        return "tours";
    }

    @GetMapping("/add")
    public String newTourView(Model model) {
        model.addAttribute("tour", new Tour());
        return "newtour";
    }

    @PostMapping("/add")
    public String newTourHandler(@RequestParam(name = "highlight[]") String[] highlights ,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            RedirectAttributes reAttr,
            BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "newtour";
        }
        
        uploadImgFile(tour);
        tourService.addTour(tour);
        
        for(String highlight : highlights){
            tourHighlightService.addHighlight(tour, highlight);
        }
        
        
        reAttr.addFlashAttribute("msg", "New Tour Added!");
        
        return "redirect:/tours";
    }

    @GetMapping("/{id}")
    public String tourDetails(@PathVariable("id") Integer id, HttpServletRequest request,
            Model model) {
        
        Tour tour = tourService.getTourById(id);
        List<Object[]> reviews = tourReviewService.getReviewsByTourId(id);
        model.addAttribute("tour", tour);
        model.addAttribute("review", new TourReview());
        model.addAttribute("reviews", reviews);
        model.addAttribute("highlights", tourHighlightService.getHighlightByTourId(id));
        model.addAttribute("pageTitle", tour.getTitle());
        request.getSession().setAttribute("currentPage", "tours/"+id);
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
        model.addAttribute("pageTitle", tour.getTitle()+" Edit");
        return "touredit";
    }

    @PostMapping("/{id}/edit")
    public String tourEditHandler(RedirectAttributes reAttr,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println(result);
            return "redirect:/tours/{id}/edit";
        }

        uploadImgFile(tour);
        tourService.editTour(tour);
        reAttr.addFlashAttribute("msg", "Tour: {id: " + tour.getId() + "} Edited!");
        
        return "redirect:/tours/{id}";
    }
    
    @GetMapping("/{id}/book")
    public String tourBookView(@PathVariable("id") Integer tourId, Model model){
        Tour tour = tourService.getTourById(tourId);
        model.addAttribute("booking", new Booking());
        model.addAttribute("tour", tour);
        model.addAttribute("ticketType", ticketTypeService.getTicketType(true));
        model.addAttribute("pageTitle", tour.getTitle()+" Booking");
        return "tourbook";
    }
    
    @PostMapping("/{id}/book")
    public String tourBookHandler(@PathVariable("id") Integer tourId, RedirectAttributes reAttr,
            @RequestParam(name = "adultticket") int adultTicket,
            @RequestParam(name = "childrenticket", required = false) int childrenTicket,
            @ModelAttribute(value = "booking") Booking booking){
        
        for(int i=1; i<=adultTicket; i++){
            booking.setTicketType(ticketTypeService.getTicketType(false));
            bookingSerivce.booking(booking, tourId);
        }
        
        if(childrenTicket>0){
            for(int i=1; i<=childrenTicket; i++){
                booking.setTicketType(ticketTypeService.getTicketType(true));
                bookingSerivce.booking(booking, tourId);
            }
        }
        
        reAttr.addFlashAttribute("msg", "Tour: (id: " + booking.getTourId() + ") Booking Successful!");
        
        return "redirect:/tours/{id}";
    }
}
