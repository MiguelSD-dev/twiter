package com.ceica.twiter.controller;

import com.ceica.twiter.model.Twit;
import com.ceica.twiter.model.User;
import com.ceica.twiter.service.TwitService;
import com.ceica.twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class indexController {

    private TwitService twitService;
    private UserService userService;

    @Autowired
    public indexController(TwitService twitService, UserService userService) {
        this.twitService = twitService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);

        List<Twit> twitList = twitService.getAllTwits();
        Collections.reverse(twitList); // Invierte la lista
        model.addAttribute("twits", twitList);
        model.addAttribute("user", user);
        return "index";
    }
}
