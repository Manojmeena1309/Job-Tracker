package com.example.jobtracker.repository;

import com.example.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Tells Spring this is a Data Access component
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    // No code needed here! 
    // JpaRepository already has methods for Save, Delete, Find, etc.
    // 'JobApplication' is the Entity, and 'Long' is the type of the ID.
}