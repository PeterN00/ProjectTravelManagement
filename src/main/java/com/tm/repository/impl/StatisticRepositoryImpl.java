/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Booking;
import com.tm.pojo.Tour;
import com.tm.repository.StatisticRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class StatisticRepositoryImpl implements StatisticRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> tourBookingCount(int limit) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root rootT = cq.from(Tour.class);
        Root rootB = cq.from(Booking.class);
        
        cq.where(cb.equal(rootB.get("tourId"), rootT.get("id")));
        cq.multiselect(rootT.get("id"), rootT.get("title"), cb.count(rootB.get("tourId")));
        cq.groupBy(rootT.get("id"));
        cq.orderBy(cb.desc(cb.count(rootB.get("tourId"))));
        Query query = session.createQuery(cq);
        query.setMaxResults(limit);
        
        return query.getResultList();
    }
}
