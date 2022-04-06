/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Booking;
import com.tm.repository.BookingRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
    private LocalSessionFactoryBean localSessionFactoryBean;
    
    @Override
    public void booking(Booking booking) {
        Session session = localSessionFactoryBean.getObject().getCurrentSession();
        session.save(booking);
    }
    
}
