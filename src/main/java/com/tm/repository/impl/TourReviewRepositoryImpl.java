/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Tour;
import com.tm.pojo.TourReview;
import com.tm.pojo.User;
import com.tm.repository.TourReviewRepository;
import com.tm.service.TourService;
import com.tm.service.UserService;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PHUC
 */
@Repository
@Transactional
public class TourReviewRepositoryImpl implements TourReviewRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userService;
    
    @Override
    public void review(TourReview tourReview, Integer tourId, Short rate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(authentication.getName());
        Tour tour = tourService.getTourById(tourId);
        
        Timestamp date = new Timestamp(new Date().getTime());
        
        tourReview.setTime(date);
        tourReview.setTourId(tour);
        tourReview.setUserId(user);
        tourReview.setRate(rate);
        
        session.save(tourReview);
    }

    @Override
    public List<Object[]> getReviewsByTourId(Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        
        Root rootT = cq.from(Tour.class);
        Root rootTR = cq.from(TourReview.class);
        Root rootU = cq.from(User.class);
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootTR.get("userId"), rootU.get("id")));
        preList.add(cb.equal(rootT.get("id"), rootTR.get("tourId")));
        preList.add(cb.equal(rootTR.get("tourId"), tourId));
        
        cq.multiselect(rootTR.get("id"), rootU.get("username"), rootU.get("img"), rootTR.get("rate"), 
                rootTR.get("comment"), rootTR.get("time"));
        cq.where(preList.toArray(new Predicate[] {}));
        
        Query query = session.createQuery(cq);
        
        return query.getResultList();
    }
    
}
