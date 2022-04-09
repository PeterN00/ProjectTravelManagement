/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Tour;
import com.tm.pojo.TourHighlight;
import com.tm.repository.TourHighlightRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    @Override
    public void addHighlight(Tour tour, String highlight) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        TourHighlight th = new TourHighlight();
        th.setTourId(tour);
        th.setHighlight(highlight);
        session.save(th);
    }
    
    @Override
    public List<String> getHighlightByTourId(Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root rootT = cq.from(Tour.class);
        Root rootTH = cq.from(TourHighlight.class);
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootTH.get("tourId"), rootT.get("id")));
        preList.add(cb.equal(rootTH.get("tourId"), tourId));
        
        cq.select(rootTH.get("highlight"));
        cq.where(preList.toArray(new Predicate[] {}));
        
        Query query = session.createQuery(cq);
        
        return query.getResultList();
    }
    
}
