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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class userController {
    private UserService userService;
    private TwitService twitService;

    @Autowired
    public userController(UserService userService, TwitService twitService) {
        this.userService = userService;
        this.twitService = twitService;
    }

    @GetMapping("/user")
    public String user(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);

        List<Twit> twitList = twitService.getTwitsByUserId(user.getId());
        model.addAttribute("twits", twitList);
        return "user";
    }

    @PostMapping("/publicar")
    public String twitear(@RequestParam String twit, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
        Twit twit1 = new Twit();
        twit1.setTwitext(twit);
        twit1.setUser_id(user.getId());
        twit1.setDate(new Date());
        twitService.save(twit1);
        return "redirect:/user";
    }
}
