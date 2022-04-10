/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.Tour;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourHighlightService {
    void addHighlight(Tour tour, String highlight);
    List<String> getHighlightByTourId(Integer tourId);
}
