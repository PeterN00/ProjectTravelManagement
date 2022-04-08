/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatisticService {
    List<Object[]> tourBookingCount(int limit, String search);
    List<Object[]> tourBookRevenue(int limit, String fromDate, String toDate, String search);
}
