package com.sanjay.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This should match login.html in templates
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // This should match register.html in templates
    }
}
