/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.TourReview;
import java.util.List;

/**
 *
 * @author PHUC
 */
public interface TourReviewService {
    void review(TourReview tourReview, Integer tourId, String rate);
    List<Object[]> getReviewsByTourId(Integer tourId);
}
