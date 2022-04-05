/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.tm.pojo.News;
import com.tm.service.NewsService;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    public void setEditDateTime(News news){
        Timestamp date = new Timestamp(new Date().getTime());
        news.setDate(date);
    }
    
    @GetMapping
    public String news(Model model, HttpServletRequest request,
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(name = "page", defaultValue = "1") Integer page) {
        
        model.addAttribute("news", newsService.getNews(search, page));
        model.addAttribute("newscount", newsService.newsCount());
        request.getSession().setAttribute("currentPage", "news");
        return "news";
    }
    
    @GetMapping("/add")
    public String addNewsView(Model model){
        model.addAttribute("news", new News());
        return "addnews";
    }
    
    @PostMapping("/add")
    public String addNewsHandler(Model model, 
            @ModelAttribute(value = "news") @Valid News news,
            BindingResult result,
            RedirectAttributes reAttr){
        
        if(result.hasErrors()){
            System.out.println(result);
            return "addnews";
        }
        
        setEditDateTime(news);
        newsService.addNews(news);
        
        reAttr.addFlashAttribute("msg", "News Added!");
        return "redirect:/news";
    }
    
    @GetMapping("/{id}")
    public String newsDetails(@PathVariable("id") Integer id, HttpServletRequest request,
            Model model) {
        
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        model.addAttribute("pageTitle", news.getTitle());
        request.getSession().setAttribute("currentPage", "news/"+id);
        return "newsdetails";
    }
    
    @RequestMapping("/{id}/delete")
    public String newsDelete(@PathVariable("id") Integer id, RedirectAttributes reAttr){
        newsService.deleteNews(id);
        reAttr.addFlashAttribute("msg", "News: {id:" + id + "} Deleted!");
        return "redirect:/news";
    }
    
    @GetMapping("/{id}/edit")
    public String newsEditView(@PathVariable("id") Integer id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("news", news);
        model.addAttribute("pageTitle", news.getTitle());
        return "newsedit";
    }

    @PostMapping("/{id}/edit")
    public String newsEditHandler(RedirectAttributes reAttr,
            @ModelAttribute(value = "news") @Valid News news,
            BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println(result);
            return "redirect:/";
        }
        
        setEditDateTime(news);
        newsService.editNews(news);
        
        reAttr.addFlashAttribute("msg", "News: {id: " + news.getId() + "} Edited!");
        return "redirect:/news/{id}";
    }
}
