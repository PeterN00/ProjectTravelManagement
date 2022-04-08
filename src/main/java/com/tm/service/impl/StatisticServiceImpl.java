/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.repository.StatisticRepository;
import com.tm.service.StatisticService;
import java.util.List;
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
    public List<Object[]> tourBookingCount(int limit) {
        return statisticRepository.tourBookingCount(limit);
    }
    
}
