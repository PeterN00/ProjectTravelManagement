/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.TicketType;
import com.tm.repository.TicketTypeRepository;
import javax.persistence.Query;
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
public class TicketTypeRepositoryImpl implements TicketTypeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public TicketType getTicketType(boolean type) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        int typeId;
        if(type==true)
            typeId = 1;
        else
            typeId = 0;
        
        Query q = session.createQuery("select t from TicketType t where type=:typeId");
        q.setParameter("typeId", typeId);
        
        return (TicketType) q.getSingleResult();
    }
    
}
