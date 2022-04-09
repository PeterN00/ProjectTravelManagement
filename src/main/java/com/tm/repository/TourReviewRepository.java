/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import com.tm.pojo.TourReview;
import java.util.List;

/**
 *
 * @author PHUC
 */
public interface TourReviewRepository {
    void review(TourReview tourReview, Integer tourId, Short rate);
    List<Object[]> getReviewsByTourId(Integer tourId);
}
