package com.sanjay.jobportal.controller;

import com.sanjay.jobportal.model.Job;
import com.sanjay.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private JobService jobService;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Job> jobs = jobService.getAllJobs();
        model.addAttribute("jobs", jobs);
        return "dashboard"; // This maps to dashboard.html
    }
}
