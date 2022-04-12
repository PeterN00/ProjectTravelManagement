/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.Booking;
import com.tm.pojo.TicketType;
import com.tm.pojo.Tour;
import com.tm.pojo.User;
import com.tm.repository.BookingRepository;
import com.tm.service.TourService;
import com.tm.service.UserService;
import java.util.ArrayList;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TourService tourService;
    @Autowired
    private UserService userService;

    @Override
    public void booking(Booking booking, Integer tourId) {
        Session session = sessionFactory.getObject().getCurrentSession();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(authentication.getName());
        Tour tour = tourService.getTourById(tourId);

        booking.setTourId(tour);
        booking.setUserId(user);
        session.save(booking);
    }

    @Override
    public List<Object[]> getBookingList(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root rootB = cq.from(Booking.class);
        Root rootTT = cq.from(TicketType.class);
        Root rootT = cq.from(Tour.class);

        Expression prod = cb.prod(rootT.get("price"), rootTT.get("discount"));
        Expression quot = cb.quot(prod, 100);
        Expression diff = cb.diff(rootT.get("price"), quot);
        Expression totalPrice = cb.sum(diff);
        
        cq.multiselect(
                rootT.get("title"),
                cb.sum(
                        cb.<Number>selectCase()
                                .when(cb.equal(rootB.get("ticketType"), Boolean.FALSE), 1)
                                .otherwise(0)).alias("adult"),
                cb.sum(
                        cb.<Number>selectCase()
                                .when(cb.equal(rootB.get("ticketType"), Boolean.TRUE), 1)
                                .otherwise(0)).alias("child"),
                totalPrice,
                rootB.get("bookDate")
        );
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootB.get("userId"), user.getId()));
        preList.add(cb.equal(rootB.get("ticketType"), rootTT.get("type")));
        preList.add(cb.equal(rootB.get("tourId"), rootT.get("id")));
        
        cq.where(preList.toArray(new Predicate[] {}));
        cq.groupBy(rootB.get("tourId"));

        Query query = session.createQuery(cq);

        return query.getResultList();
    }
}
