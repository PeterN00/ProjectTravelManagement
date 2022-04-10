/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.Tour;
import com.tm.pojo.TourItinerary;
import com.tm.repository.TourItineraryRepository;
import com.tm.service.TourItineraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TourItineraryServiceImpl implements TourItineraryService {

    @Autowired
    private TourItineraryRepository tourItineraryRepository;
    
    @Override
    public void addItinerary(Tour tour, String name, String description) {
        tourItineraryRepository.addItinerary(tour, name, description);
    }

    @Override
    public List<TourItinerary> getItineraryByTourId(Integer tourId) {
        return tourItineraryRepository.getItineraryByTourId(tourId);
    }

    @Override
    public void deleteItinerary(Tour tour) {
        tourItineraryRepository.deleteItinerary(tour);
    }
    
}
