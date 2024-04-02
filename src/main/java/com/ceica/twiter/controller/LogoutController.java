package com.ceica.twiter.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout() {
        // Invalidar la sesión actual
        SecurityContextHolder.getContext().setAuthentication(null);
        // Redireccionar al usuario a la página de inicio
        return "redirect:/";
    }
}

