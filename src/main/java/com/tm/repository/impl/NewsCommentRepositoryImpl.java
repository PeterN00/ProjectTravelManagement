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
        
        newsComment.setUserId(user);
        newsComment.setNewsId(news);
        
        session.save(newsComment);
    }
    
}
