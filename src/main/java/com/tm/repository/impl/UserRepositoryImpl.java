/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.User;
import com.tm.repository.UserRepository;
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

    @Override
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root root = cq.from(User.class);
        cq.select(root);
        cq.where(cb.equal(root.get("username"), username));
        Query query = session.createQuery(cq);
        
        return (User) query.getSingleResult();
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.update(user);
    }
}
