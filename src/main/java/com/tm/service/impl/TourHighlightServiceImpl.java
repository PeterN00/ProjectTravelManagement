/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.Tour;
import com.tm.repository.TourHighlightRepository;
import com.tm.service.TourHighlightService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class TourHighlightServiceImpl implements TourHighlightService {
    @Autowired
    private TourHighlightRepository tourHighlightRepository;
    
    @Override
    public void addHighlight(Tour tour, String highlight) {
        tourHighlightRepository.addHighlight(tour, highlight);
    }
    
    @Override
    public List<String> getHighlightByTourId(Integer tourId) {
        return tourHighlightRepository.getHighlightByTourId(tourId);
    }
    
}
