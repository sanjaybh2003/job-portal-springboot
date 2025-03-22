package com.sanjay.jobportal.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String company;
    private String location;
    private String type;

    // Default constructor (required by JPA)
    public Job() {
    }

    // Updated constructor matching JobController usage
    public Job(String title, String description, String company) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.location = "Not specified";  // Default location
        this.type = "Full-time";          // Default job type
    }

    // Existing constructor (if needed for other parts of the application)
    public Job(String title, String company, String location, String description, String type) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.type = type;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
