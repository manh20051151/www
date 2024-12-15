package com.example.week05_lab_NguyenVietManh_20051151.repository;

import com.example.week05_lab_NguyenVietManh_20051151.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
