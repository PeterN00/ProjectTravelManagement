/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.Booking;
import com.tm.pojo.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface BookingService {
    void booking(Booking booking, Integer tourId);
    List<Object[]> getBookingList(User user);
}
