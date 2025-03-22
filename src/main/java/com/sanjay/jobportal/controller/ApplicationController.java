package com.sanjay.jobportal.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @PostMapping("/apply")
    public String applyJob() {
        return "Application Submitted";
    }
}
