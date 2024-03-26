package com.ceica.twiter.controller;

import com.ceica.twiter.model.Twit;
import com.ceica.twiter.model.User;
import com.ceica.twiter.repository.TwitRepository;
import com.ceica.twiter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class userController {
    private UserService userService;
    private TwitRepository twitRepository;


    @Autowired
    public userController(UserService userService,TwitRepository twitRepository) {
        this.userService = userService;
        this.twitRepository=twitRepository;
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @PostMapping("/publicar")
    public String twitear(@RequestParam String twit, Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
         User user=userService.getUserByUsername(username);
        Twit twit1=new Twit();
        twit1.setTwitext(twit);
        twit1.setUser_id(user.getId());
        twit1.setDate(new Date());
        twitRepository.save(twit1);
        System.out.println(twit);
        List<Twit> twitList=twitRepository.findAll();
        model.addAttribute("twits",twitList);
        return "user";
    }
}
