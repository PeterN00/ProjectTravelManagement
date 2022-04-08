/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface StatisticRepository {
    List<Object[]> tourBookingCount(int limit, String search);
    List<Object[]> tourBookRevenue(int limit, Date fromDate, Date toDate, String search);
}
