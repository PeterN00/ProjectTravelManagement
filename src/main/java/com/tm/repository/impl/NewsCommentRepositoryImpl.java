/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.News;
import com.tm.pojo.NewsComment;
import com.tm.pojo.User;
import com.tm.repository.NewsCommentRepository;
import com.tm.service.NewsService;
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
public class NewsCommentRepositoryImpl implements NewsCommentRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private NewsService newsService;
    @Autowired
    private UserService userService;
    
    @Override
    public void comment(NewsComment newsComment, Integer newsId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByUsername(authentication.getName());
        News news = newsService.getNewsById(newsId);
        
        Timestamp date = new Timestamp(new Date().getTime());
        
        newsComment.setTime(date);
        newsComment.setUserId(user);
        newsComment.setNewsId(news);
        
        session.save(newsComment);
    }

    @Override
    public List<Object[]> getCommentsByNewsId(Integer newsId) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        
        Root rootN = cq.from(News.class);
        Root rootNC = cq.from(NewsComment.class);
        Root rootU = cq.from(User.class);
        
        List<Predicate> preList = new ArrayList();
        preList.add(cb.equal(rootNC.get("userId"), rootU.get("id")));
        preList.add(cb.equal(rootNC.get("newsId"), rootN.get("id")));
        preList.add(cb.equal(rootNC.get("newsId"), newsId));
        
        cq.multiselect(rootNC.get("id"), rootU.get("username"), rootU.get("img"),
                rootNC.get("comment"), rootNC.get("time"));
        cq.where(preList.toArray(new Predicate[] {}));
        
        Query query = session.createQuery(cq);
        
        return query.getResultList();
    }
    
}
