package com.example.jobtracker.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity // This tells Spring Boot: "This class represents a table in MySQL"
@Table(name = "job_applications") // Optional: Sets the specific name of the table
public class JobApplication {

    @Id // Marks this field as the Primary Key (Unique ID for every row)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells MySQL to auto-increment the ID (1, 2, 3...)
    private Long id;

@Column(nullable = false)
private String companyName;

private String jobTitle;


    // We use an Enum or String to track the progress
    private String status; // e.g., "Applied", "Interview", "Rejected"

    private LocalDate dateApplied;

    // --- Standard Getters and Setters ---
    // (Interview Tip: In a real job, we use a tool called Lombok to hide these, 
    // but writing them out shows you understand the basics!)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateApplied() { return dateApplied; }
    public void setDateApplied(LocalDate dateApplied) { this.dateApplied = dateApplied; }
}
