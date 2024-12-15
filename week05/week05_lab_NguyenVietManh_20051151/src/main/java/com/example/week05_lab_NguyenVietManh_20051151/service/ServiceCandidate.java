package com.example.week05_lab_NguyenVietManh_20051151.service;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Candidate;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Company;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Job;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Skill;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoCandidate;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoCompany;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoJob;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCandidate {
    @Autowired
    private RepoJob repoJob;

    @Autowired
    private RepoSkill repoSkill;

    @Autowired
    private RepoCandidate repoCandidate;

    public void updateSkill(List<Long> skillIds, Candidate candidate) {
        List<Skill> skills = repoSkill.findAllById(skillIds);
        candidate.setSkills(skills);
        repoCandidate.save(candidate);
    }
    public List<Job> findJobsBySkills(List<Skill> skills) {
        return repoJob.findJobsBySkills(skills);
    }
    public Optional<Candidate> findById(Long id){
        return repoCandidate.findById(id);
    }
    public List<Job> findAllJob(){
        return repoJob.findAll();
    }
    public void updateCandidate(Candidate candidate) {
        repoCandidate.save(candidate);
    }
}
