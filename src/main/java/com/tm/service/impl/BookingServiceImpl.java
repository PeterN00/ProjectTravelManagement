/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.Booking;
import com.tm.pojo.User;
import com.tm.repository.BookingRepository;
import com.tm.service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Override
    public void booking(Booking booking, Integer tourId) {
        this.bookingRepository.booking(booking, tourId);
    }

    @Override
    public List<Object[]> getBookingList(User user) {
        return bookingRepository.getBookingList(user);
    }
    
}
