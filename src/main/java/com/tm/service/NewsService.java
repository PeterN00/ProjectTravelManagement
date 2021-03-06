/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.News;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NewsService {
    List<News> getNews(String search, int page);
    int newsCount();
    void addNews(News news);
    News getNewsById(Integer id);
    void deleteNews(Integer id);
    void editNews(News news);
}
