/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.service;

import com.tm.pojo.NewsComment;
import java.util.List;

/**
 *
 * @author PHUC
 */
public interface NewsCommentService {
    void comment(NewsComment newsComment, Integer newsId);
    List<Object[]> getCommentsByNewsId(Integer newsId);
}
