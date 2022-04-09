/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.service.impl;

import com.tm.pojo.NewsComment;
import com.tm.repository.NewsCommentRepository;
import com.tm.service.NewsCommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PHUC
 */
@Service
public class NewsCommentServiceImpl implements NewsCommentService{
    
    @Autowired
    private NewsCommentRepository newsCommentRepository;
    
    @Override
    public void comment(NewsComment newsComment, Integer newsId) {
        newsCommentRepository.comment(newsComment, newsId);
    }

    @Override
    public List<Object[]> getCommentsByNewsId(Integer newsId) {
        return newsCommentRepository.getCommentsByNewsId(newsId);
    }
    
}
