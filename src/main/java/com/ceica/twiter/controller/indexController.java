package com.ceica.twiter.controller;

import com.ceica.twiter.model.Twit;
import com.ceica.twiter.service.TwitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class indexController {

    private TwitService twitService;

    @Autowired
    public indexController(TwitService twitService) {
        this.twitService = twitService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Twit> twitList = twitService.getAllTwits();
        Collections.reverse(twitList); // Invierte la lista
        model.addAttribute("twits", twitList);
        return "index";
    }
}
