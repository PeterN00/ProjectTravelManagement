/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.Tour;
import com.tm.repository.TourRepository;
import com.tm.service.TourService;
import java.util.List;
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
        this.tourRepository.addTour(tour);
    }

    @Override
    public Tour getTourById(Integer id) {
        return this.tourRepository.getTourById(id);
    }

    @Override
    public void deleteTour(Integer id) {
        this.tourRepository.deleteTour(id);
    }
}
