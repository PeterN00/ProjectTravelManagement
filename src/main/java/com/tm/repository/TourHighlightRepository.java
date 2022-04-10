/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import com.tm.pojo.Tour;
import com.tm.pojo.TourHighlight;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourHighlightRepository {
    void addHighlight(Tour tour, String highlight);
    List<TourHighlight> getHighlightByTourId(Integer tourId);
    void deleteHighlights(Tour tour);
}
