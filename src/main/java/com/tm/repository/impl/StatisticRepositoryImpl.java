/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Booking;
import com.tm.pojo.TicketType;
import com.tm.pojo.Tour;
import com.tm.repository.StatisticRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
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
public class StatisticRepositoryImpl implements StatisticRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> tourBookingCount(int limit, String search) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root rootT = cq.from(Tour.class);
        Root rootB = cq.from(Booking.class);
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootB.get("tourId"), rootT.get("id")));
        if(search != null && !search.isEmpty())
            preList.add(cb.like(rootT.get("title").as(String.class), String.format("%%%s%%", search)));
        
        cq.multiselect(rootT.get("id"), rootT.get("title"), cb.count(rootB.get("tourId")));
        cq.where(preList.toArray(new Predicate[] {}));
        cq.groupBy(rootT.get("id"));
        cq.orderBy(cb.desc(cb.count(rootB.get("tourId"))));
        
        Query query = session.createQuery(cq);
        query.setMaxResults(limit);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> tourBookRevenue(int limit, Date fromDate, Date toDate, String search) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root rootT = cq.from(Tour.class);
        Root rootB = cq.from(Booking.class);
        Root rootTType = cq.from(TicketType.class);
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootB.get("tourId"), rootT.get("id")));
        preList.add(cb.equal(rootB.get("ticketType"), rootTType.get("type")));
        if(search != null && !search.isEmpty())
            preList.add(cb.like(rootT.get("title").as(String.class), String.format("%%%s%%", search)));
        if(fromDate != null)
            preList.add(cb.greaterThanOrEqualTo(rootB.get("bookDate"), fromDate));
        if(toDate != null)
            preList.add(cb.lessThanOrEqualTo(rootB.get("bookDate"), toDate));
        
        //tour price - tour price * ticketType discount%
        Expression<Number> prod = cb.prod(rootT.get("price"), rootTType.get("discount"));
        Expression<Number> quot = cb.quot(prod, 100);
        Expression<Number> diff = cb.diff(rootT.get("price"), quot);
        Expression<Number> sum = cb.sum(diff);
        
        List<Expression> exList = new ArrayList();
        exList.add(rootT.get("id"));
        exList.add(cb.function("MONTH", Integer.class, rootB.get("bookDate")));
        
        cq.multiselect(rootT.get("id"), rootT.get("title"), 
                cb.function("MONTH", Integer.class, rootB.get("bookDate")), 
                cb.function("YEAR", Integer.class, rootB.get("bookDate")),
                sum);
        cq.where(preList.toArray(new Predicate[] {}));
        cq.groupBy(exList.toArray(new Expression[] {}));
        cq.orderBy(cb.desc(sum));
        
        Query query = session.createQuery(cq);
        query.setMaxResults(limit);
        
        return query.getResultList();
    }
}
