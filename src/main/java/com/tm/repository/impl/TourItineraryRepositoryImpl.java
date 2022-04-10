/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Tour;
import com.tm.pojo.TourItinerary;
import com.tm.repository.TourItineraryRepository;
import com.tm.service.TourItineraryService;
import com.tm.service.TourService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;
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
public class TourItineraryRepositoryImpl implements TourItineraryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TourService tourService;
    
    @Override
    public void addItinerary(Tour tour, String name, String description) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        TourItinerary ti = new TourItinerary();
        ti.setTourId(tour);
        ti.setName(name);
        ti.setDescription(description);
        session.save(ti);
    }
    
    @Override
    public List<TourItinerary> getItineraryByTourId(Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Tour tour = tourService.getTourById(tourId);
        List<TourItinerary> list = tour.getTourItineraryList();
        Hibernate.initialize(list);
        return list;
    }
}