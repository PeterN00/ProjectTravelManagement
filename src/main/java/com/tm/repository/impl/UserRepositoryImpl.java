/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.User;
import com.tm.repository.UserRepository;
import java.util.List;
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
public class UserRepositoryImpl implements  UserRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM User");
        return q.getResultList();
    }
    
    @Override
    public void addUser(User user){
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(user);
    }
}
