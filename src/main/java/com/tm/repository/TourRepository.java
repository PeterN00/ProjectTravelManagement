/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import com.tm.pojo.Tour;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TourRepository {
    List<Tour> getTours(String search, int page, Float maxPrice, Date fromDate, Date toDate);
    int tourCount();
    void addTour(Tour tour);
    Tour getTourById(Integer id);
    void deleteTour(Integer id);
    void editTour(Tour tour);
    Float getHighestPrice();
}
