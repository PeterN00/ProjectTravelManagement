/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Booking;
import com.tm.pojo.Tour;
import com.tm.pojo.User;
import com.tm.repository.BookingRepository;
import com.tm.service.TourService;
import com.tm.service.UserService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userService;
    
    @Override
    public void booking(Booking booking, Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(authentication.getName());
        Tour tour = tourService.getTourById(tourId);
        
        booking.setTourId(tour);
        booking.setUserId(user);
        session.save(booking);
    }
    
}
