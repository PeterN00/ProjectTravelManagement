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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Cloudinary cloudinary;

    public void uploadImgFile(User user) {
        if (!user.getImgFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(user.getImgFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto",
                                "folder", "travelmanagementproject_userimg",
                                "public_id", user.getImgFile().getOriginalFilename()
                        ));
                user.setImg((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @GetMapping("/register")
    public String register(Model model, HttpServletRequest request) {
        model.addAttribute("user", new User());
        request.getSession().setAttribute("currentPage", "register");
        return "register";
    }

    @PostMapping("/register")
    public String registerHandler(Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result);
            return "register";
        }

        String msg;
        String statusMsg;
        if (user.getPassword().equals(user.getRetypePassword())) {
            uploadImgFile(user);
            userService.addUser(user);
            statusMsg = "New account registered!";
            model.addAttribute("statusmsg", statusMsg);
            return "register";
        } else {
            msg = "Password does not match!";
        }

        model.addAttribute("msg", msg);

        return "register";
    }

    @GetMapping("/{username}")
    public String userProfile(@PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", username);
        return "userprofile";
    }

    @GetMapping("/{username}/edit")
    public String userProfileEditView(@PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
        user.setPassword("");
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", username + " Edit");
        return "userprofileedit";
    }

    @PostMapping("/{username}/edit")
    public String userProfileEditHandler(RedirectAttributes reAttr,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        
        if (result.hasErrors()) {
            System.out.println(result);
            return "redirect:/users/{username}/edit";
        }
        
        if (user.getPassword().equals(user.getRetypePassword())) {
            uploadImgFile(user);
            userService.editUser(user);
            reAttr.addFlashAttribute("msg", "User (id: " + user.getId() + "} Edited!");
            return "redirect:/users/{username}";
        } else {
            reAttr.addFlashAttribute("errmsg", "Password does not match!");
        }

        return "redirect:/users/{username}/edit";
    }
}
