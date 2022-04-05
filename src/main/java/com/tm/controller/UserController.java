/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tm.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tm.pojo.User;
import com.tm.service.UserService;
import java.io.IOException;
import java.util.Map;
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

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request){
        model.addAttribute("user", new User());
        model.addAttribute("users", this.userService.getUsers());
        request.getSession().setAttribute("currentPage", "register");
        return "register";
    }
    
    @PostMapping("/register")
    public String registerHandler(Model model,
            @ModelAttribute(value = "user") @Valid User user, 
            BindingResult result){
        
        if(result.hasErrors() == true){
            System.out.println(result);
            return "register";
        }
        
        if (user.getImgFile() != null) {
            try {
                Map res = cloudinary.uploader().upload(user.getImgFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto",
                                "folder", "travelmanagementproject_userimg"
                        ));
                user.setImg((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        String msg;
        String statusMsg;
        if(user.getPassword().equals(user.getRetypePassword())){
            userService.addUser(user);
            statusMsg = "New account registered!";
            model.addAttribute("statusmsg", statusMsg);
            model.addAttribute("regstatus", statusMsg);
            return "register";
        }else
            msg = "Password does not match!";
        
        model.addAttribute("msg", msg);
        
        return "register";
    }
    
    @GetMapping("/user/{username}")
    public String userProfile(@PathVariable("username") String username, Model model){
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", username);
        return "userprofile";
    }
}
