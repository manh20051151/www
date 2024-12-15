package com.example.week05_lab_NguyenVietManh_20051151.repository;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Company;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Job;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoJob extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j JOIN j.skills s WHERE s IN :skills")
    List<Job> findJobsBySkills(@Param("skills") List<Skill> skills);
    List<Job> findJobsByCompany(Company company);
}
