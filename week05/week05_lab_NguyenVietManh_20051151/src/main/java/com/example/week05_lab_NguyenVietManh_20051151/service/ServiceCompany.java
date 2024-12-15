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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompany {
    @Autowired
    private RepoJob repoJob;

    @Autowired
    private RepoSkill repoSkill;

    @Autowired
    private RepoCompany repoCompany;

    @Autowired
    private RepoCandidate repoCandidate;

    public List<Job> getAllJob(){
        return repoJob.findAll();
    }
    @Transactional
    public List<Skill> getAllSkill(){
        return repoSkill.findAll();
    }

    public void createJob(String jobName, String jobDesc, List<Long> skillIds, Company company) {
        Job job = new Job();
        job.setJobName(jobName);
        job.setJobDesc(jobDesc);
        job.setCompany(company);
        List<Skill> skills = repoSkill.findAllById(skillIds);
        job.setSkills(skills);

        repoJob.save(job);
    }
    public Optional<Job> findById(Long id){
        return repoJob.findById(id);
    }

    public List<Job> findByCompany(Company company){
        return repoJob.findJobsByCompany(company);
    }
    public List<Candidate> findCandidatesBySkills(List<Skill> jobSkills) {
        return repoCandidate.findCandidatesBySkills(jobSkills);
    }
    public void updateCompany(Company company) {
        repoCompany.save(company);
    }
    public Job findById2(Long id) {
        return repoJob.findById(id).orElse(null);
    }
    public void updateJob(Long jobId, String jobName, String jobDesc, List<Long> skillIds, Company account) {

        Job job = repoJob.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        job.setJobName(jobName);
        job.setJobDesc(jobDesc);


        List<Skill> skills = repoSkill.findAllById(skillIds);
        job.setSkills(skills);


        repoJob.save(job);
    }

    public void deleteById(Long jobId) {

        if (repoJob.existsById(jobId)) {
            repoJob.deleteById(jobId);
        } else {
            throw new RuntimeException("Job not found with id: " + jobId);
        }
    }
}
