package com.example.week05_lab_nguyenvietmanh_20051151;

import com.example.week05_lab_nguyenvietmanh_20051151.entity.Candidate;
import com.example.week05_lab_nguyenvietmanh_20051151.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class Week05LabNguyenVietManh20051151Application implements CommandLineRunner {
    @Autowired
    private CandidateRepository candidateRepository;
    public static void main(String[] args) {
        SpringApplication.run(Week05LabNguyenVietManh20051151Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Test CRUD actions here

        // Test saving a candidate
//        Candidate candidate = new Candidate();
//        candidate.setId(Long.valueOf("2"));
//        candidate.setFirstName("John");
//        candidate.setMiddleName("Doe");
//        candidate.setLastName("Smith");
//        candidate.setDob(new Date(System.currentTimeMillis()).toLocalDate());
//        candidate.setEmail("john.smith@example.com");
//        candidate.setAddress("123 Main St");
//        candidate.setPhone("555-1234");
//
//        candidateRepository.save(candidate);
//        System.out.println("Candidate saved: " + candidate);

//        // Test finding candidate by ID
//        Candidate foundCandidate = candidateRepository.findById("2");
//        System.out.println("Candidate found: " + foundCandidate);
//
//        // Test updating candidate
//        foundCandidate.setFirstName("Johnny");
//        candidateRepository.update(foundCandidate);
//        System.out.println("Candidate updated: " + foundCandidate);
//
//        // Test deleting candidate
//        candidateRepository.deleteById("2");
//        System.out.println("Candidate deleted");
//
//        // Test finding all candidates (should be empty now)
        System.out.println("All candidates: " + candidateRepository.findAll());
    }

}
