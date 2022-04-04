/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import com.tm.pojo.News;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface NewsRepository {
    List<News> getNews(String search, int page);
    int newsCount();
    News getNewsById(Integer id);
    void deleteNews(Integer id);
    void editNews(News news);
}
