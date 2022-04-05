/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.repository.impl;

import com.tm.pojo.News;
import com.tm.repository.NewsRepository;
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
public class NewsRepositoryImpl implements NewsRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;
    
    @Override
    public List<News> getNews(String search, int page) {
        Session session = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root root = cq.from(News.class);
        cq.select(root);
        
        if(search != null && !search.isEmpty()){
            Predicate p = cb.like(root.get("title").as(String.class), String.format("%%%s%%", search));
            cq.where(p);
        }
        
        Query q = session.createQuery(cq);
        
        int pageSize = Integer.parseInt(env.getProperty("maximumNewsDisplayed"));
        int start = (page - 1) * pageSize;
        
        q.setMaxResults(pageSize);
        q.setFirstResult(start);
        
        return q.getResultList();
    }

    @Override
    public int newsCount() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select count(*) from News");
        Object obj = q.getSingleResult();
        int count = Integer.parseInt(obj.toString());
        return count;
    }

    @Override
    public News getNewsById(Integer id) {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select n from News n where n.id="+id);
        Object obj = q.getSingleResult();
        return (News) obj;
    }

    @Override
    public void deleteNews(Integer id) {
        News news = getNewsById(id);
        Session session = sessionFactory.getObject().getCurrentSession();
        session.delete(news);
    }

    @Override
    public void editNews(News news) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.update(news);
    }

    @Override
    public void addNews(News news) {
        Session session = sessionFactory.getObject().getCurrentSession();
        session.save(news);
    }
    
}
