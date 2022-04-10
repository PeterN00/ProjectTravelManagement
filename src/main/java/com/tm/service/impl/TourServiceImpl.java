/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.Tour;
import com.tm.repository.TourRepository;
import com.tm.service.TourService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Tour> getTours(String search, int page, String maxPrice, String fromDate, String toDate) {
        Float price = Float.parseFloat(maxPrice);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        
        if(fromDate != null && !fromDate.isEmpty())
            try {
                from = sdf.parse(fromDate);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(toDate != null && !toDate.isEmpty())
            try {
                to = sdf.parse(toDate);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.tourRepository.getTours(search, page, price, from, to);
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

    @Override
    public void editTour(Tour tour) {
        this.tourRepository.editTour(tour);
    }

    @Override
    public Float getHighestPrice() {
        return this.tourRepository.getHighestPrice();
    }
}
