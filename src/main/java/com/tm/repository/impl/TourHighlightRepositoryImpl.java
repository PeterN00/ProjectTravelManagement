/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Tour;
import com.tm.pojo.TourHighlight;
import com.tm.repository.TourHighlightRepository;
import com.tm.service.TourService;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
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
public class TourHighlightRepositoryImpl implements TourHighlightRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TourService tourService;
    
    @Override
    public void addHighlight(Tour tour, String highlight) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        TourHighlight th = new TourHighlight();
        th.setTourId(tour);
        th.setHighlight(highlight);
        session.save(th);
    }
    
    @Override
    public List<TourHighlight> getHighlightByTourId(Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Tour tour = tourService.getTourById(tourId);
        List<TourHighlight> list = tour.getTourHighlightList();
        Hibernate.initialize(list);
        return list;
    }

    @Override
    public void deleteHighlights(Tour tour) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<TourHighlight> cd = cb.createCriteriaDelete(TourHighlight.class);
        
        Root rootTH = cd.from(TourHighlight.class);
        
        cd.where(cb.equal(rootTH.get("tourId"), tour.getId()));
        
        Query query = session.createQuery(cd);
        query.executeUpdate();
    }
    
}
