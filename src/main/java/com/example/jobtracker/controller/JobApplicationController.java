
package com.example.jobtracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.service.JobApplicationService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController // Tells Spring this class will handle RESTful web requests
@RequestMapping("/api/jobs") // Sets the base URL for all endpoints in this file
@Validated
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    /**
     * POST: http://localhost:8080/api/jobs
     * Used to create a new job application.
     */

@PostMapping
public JobApplication addJobApplication(@RequestBody JobApplication application) {
    return service.addJobApplication(application);
}


    /**
     * GET: http://localhost:8080/api/jobs
     * Used to retrieve a list of all applications.
     */
    @GetMapping
    public List<JobApplication> getAllJobApplications() {
        return service.getAllJobApplications();
    }

    /**
     * PUT: http://localhost:8080/api/jobs/1/status?newStatus=Accepted
     * Updates the status of a specific application using its ID.
     */
@PutMapping("/{id}/status")
public JobApplication updateJobStatus(
        @PathVariable Long id,
        @RequestParam String status
) {
    return service.updateJobStatus(id, status);
}


    /**
     * DELETE: http://localhost:8080/api/jobs/1
     * Deletes an application from the database.
     */
@DeleteMapping("/{id}")
public String deleteJob(@PathVariable Long id) {
    service.deleteJobApplication(id);
    return "Job deleted successfully";
}

}