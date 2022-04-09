/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.TourReview;
import com.tm.repository.TourReviewRepository;
import com.tm.service.TourReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PHUC
 */
@Service
public class TourReviewServiceImpl implements TourReviewService{
    @Autowired
    private TourReviewRepository tourReviewRepository;
    
    @Override
    public void review(TourReview tourReview, Integer tourId, String rate) {
        Short r = Short.valueOf(rate);
        tourReviewRepository.review(tourReview, tourId, r);
    }

    @Override
    public List<Object[]> getReviewsByTourId(Integer tourId) {
        return tourReviewRepository.getReviewsByTourId(tourId);
    }
    
}
