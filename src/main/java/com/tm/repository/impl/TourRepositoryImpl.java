/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Tour;
import com.tm.repository.TourRepository;
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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
@PropertySource("classpath:pageinfo.properties")
public class TourRepositoryImpl implements TourRepository{
    @Autowired 
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    
    @Override
    public List<Tour> getTours(String search, int page, Float maxPrice, Date fromDate, Date toDate) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Tour> cq = cb.createQuery(Tour.class);
        Root root = cq.from(Tour.class);
        cq.select(root);
        
        List<Predicate> preList = new ArrayList();
        if(search != null && !search.isEmpty())
            preList.add(cb.like(root.get("title").as(String.class), String.format("%%%s%%", search)));
        
        preList.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
        
        if(fromDate != null)
            preList.add(cb.greaterThanOrEqualTo(root.get("departureTime"), fromDate));
        if(toDate != null)
            preList.add(cb.lessThanOrEqualTo(root.get("departureTime"), toDate));
        
        
        cq.where(preList.toArray(new Predicate[]{}));
        cq.orderBy(cb.desc(root.get("price")));
        
        Query q = session.createQuery(cq);
        
        int pageSize = Integer.parseInt(env.getProperty("maximumToursDisplayed"));
        int start = (page - 1) * pageSize;
        
        q.setMaxResults(pageSize);
        q.setFirstResult(start);
        
        return q.getResultList();
    }
    
    @Override
    public int tourCount(){
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select count(*) from Tour");
        Object obj = q.getSingleResult();
        int count = Integer.parseInt(obj.toString());
        return count;
    }

    @Override
    public void addTour(Tour tour) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(tour);
    }

    @Override
    public Tour getTourById(Integer id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select t from Tour t where t.id=:id");
        q.setParameter("id", id);
        return (Tour) q.getSingleResult();
    }

    @Override
    public void deleteTour(Integer id) {
        Tour tour = getTourById(id);
        Session session = sessionFactory.getObject().getCurrentSession();
        session.delete(tour);
    }

    @Override
    public void editTour(Tour tour) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.update(tour);
    }

    @Override
    public Float getHighestPrice() {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Float> cq = cb.createQuery(Float.class);
        
        Root root = cq.from(Tour.class);
        cq.select(root.get("price"));
        cq.orderBy(cb.desc(root.get("price")));
        
        Query query = session.createQuery(cq);
        query.setMaxResults(1);
        
        return (Float) query.getSingleResult();
    }
}
