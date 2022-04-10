/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.Tour;
import com.tm.pojo.TourItinerary;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourItineraryService {
    void addItinerary(Tour tour, String name, String description);
    List<TourItinerary> getItineraryByTourId(Integer tourId);
    void deleteItinerary(Tour tour);
}
