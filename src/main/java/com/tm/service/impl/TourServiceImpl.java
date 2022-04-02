/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tm.pojo.Tour;
import com.tm.repository.TourRepository;
import com.tm.service.TourService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
//    @Autowired
//    private Cloudinary cloudinary;
    
    @Override
    public List<Tour> getTours(String search, int page) {
        return this.tourRepository.getTours(search, page);
    }
    
    @Override
    public int tourCount(){
        return this.tourRepository.tourCount();
    }
    
    @Override
    public void addTour(Tour tour) {
//        if(tour.getImgFile() != null){
//            try {
//                Map res = cloudinary.uploader().upload(tour.getImgFile().getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
//                tour.setImg((String) res.get("secure_url"));
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//        }
        
        this.tourRepository.addTour(tour);
    }
}
