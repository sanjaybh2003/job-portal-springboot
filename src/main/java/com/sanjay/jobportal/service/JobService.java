package com.sanjay.jobportal.service;

import com.sanjay.jobportal.model.Job;
import com.sanjay.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get job by ID
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    // Add a new job
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    // Delete a job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
