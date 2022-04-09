/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tm.repository;

import com.tm.pojo.NewsComment;

/**
 *
 * @author PHUC
 */
public interface NewsCommentRepository {
    void comment(NewsComment newsComment, Integer newsId);
}
