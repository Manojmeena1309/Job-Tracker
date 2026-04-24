
package com.example.jobtracker.service;

import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Tells Spring that this class is a Service component
public class JobApplicationService {

    // Inject the Repository to interact with the database
    @Autowired
    private JobApplicationRepository repository;

    /**
     * Create/Save a new job application.
     */
    
    public JobApplication addJobApplication(JobApplication application) {

    // Manual validation
    if (application == null) {
        throw new IllegalArgumentException("Request body cannot be empty");
    }

    if (application.getCompanyName() == null || application.getCompanyName().isBlank()) {
        throw new IllegalArgumentException("Company name is required");
    }

    if (application.getJobTitle() == null || application.getJobTitle().isBlank()) {
        throw new IllegalArgumentException("Job title is required");
    }

    // Save only if validation passes
    return repository.save(application);
}


    /**
     * Retrieve all applications from the database.
     */
    public List<JobApplication> getAllJobApplications() {
        return repository.findAll();
    }

    /**
     * Update only the status of an existing application (e.g., "Pending" to "Accepted").
     */
public JobApplication updateJobStatus(Long id, String newStatus) {
    JobApplication application = repository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(
                    "Job not found with id: " + id
            ));

    application.setStatus(newStatus);
    return repository.save(application);
}


    /**
     * Remove an application from the database using its ID.
     */
public void deleteJobApplication(Long id) {
    if (!repository.existsById(id)) {
        throw new IllegalArgumentException(
                "Job not found with id: " + id
        );
    }
    repository.deleteById(id);
}

}
