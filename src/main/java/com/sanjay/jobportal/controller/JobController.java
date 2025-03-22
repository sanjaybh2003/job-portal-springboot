package com.sanjay.jobportal.controller;

import com.sanjay.jobportal.model.Job;
import com.sanjay.jobportal.repository.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.annotation.PostConstruct;

@Controller
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Populate some sample jobs when the application starts
    @PostConstruct
    public void init() {
        if (jobRepository.count() == 0) {
            jobRepository.save(new Job("Software Engineer", "Develop scalable applications.", "Google"));
            jobRepository.save(new Job("Data Analyst", "Analyze and interpret data trends.", "Amazon"));
            jobRepository.save(new Job("Backend Developer", "Design RESTful APIs and backend services.", "Microsoft"));
        }
    }

    // Show job form
    @GetMapping("/add-job")
    public String showAddJobForm(Model model) {
        model.addAttribute("job", new Job());
        return "add-job"; // Points to add-job.html
    }

    // Handle form submission
    @PostMapping("/add-job")
    public String addJob(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/dashboard"; // Redirect to updated job list
    }

    // Show all jobs on the dashboard
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "dashboard"; // Points to dashboard.html
    }
}
