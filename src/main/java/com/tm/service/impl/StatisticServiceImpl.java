/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.repository.StatisticRepository;
import com.tm.service.StatisticService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class StatisticServiceImpl implements StatisticService{
    @Autowired
    private StatisticRepository statisticRepository;
    
    @Override
    public List<Object[]> tourBookingCount(int limit, String search) {
        return statisticRepository.tourBookingCount(limit, search);
    }

    @Override
    public List<Object[]> tourBookRevenue(int limit, String fromDate, String toDate, String search) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date from = null;
        Date to = null;
        
        if(fromDate != null && !fromDate.isEmpty())
            try {
                from = sdf.parse(fromDate);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(toDate != null && !toDate.isEmpty())
            try {
                to = sdf.parse(toDate);
        } catch (ParseException ex) {
            Logger.getLogger(StatisticServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return statisticRepository.tourBookRevenue(limit, from, to, search);
    }
    
}
