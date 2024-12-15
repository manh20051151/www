package com.example.week05_lab_NguyenVietManh_20051151.controller;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Candidate;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Company;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Job;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Skill;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoJob;
import com.example.week05_lab_NguyenVietManh_20051151.service.EmailService;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceCandidate;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceCompany;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ContrCandidate {
    @Autowired
    private ServiceCompany serviceCompany;
    @Autowired
    private ServiceCandidate serviceCandidate;
    @Autowired
    private EmailService emailService;

    @Autowired
    private RepoJob repoJob;
    @GetMapping("/candidatehome")
    public String showListJob(Model model, HttpSession session) {
        Candidate account = (Candidate) session.getAttribute("user");
        List<Skill> candidateSkills = account.getSkills();

        List<String> candidateSkill = account.getSkills().stream()
                .map(Skill::getSkillName)
                .collect(Collectors.toList());
        model.addAttribute("candidateSkills", candidateSkill);

        List<Job> jobs = serviceCandidate.findJobsBySkills(candidateSkills);
        java.util.Collections.reverse(jobs);
        model.addAttribute("jobs", jobs);

        return "candidatehome";
    }

    @GetMapping("/candidatehomeall")
    public String showListAllJob(Model model, HttpSession session) {
        Candidate account = (Candidate) session.getAttribute("user");
        List<String> candidateSkill = account.getSkills().stream()
                .map(Skill::getSkillName)
                .collect(Collectors.toList());
        model.addAttribute("candidateSkills", candidateSkill);
        List<Skill> candidateSkills = account.getSkills();
        List<Job> jobs = serviceCandidate.findAllJob();
        java.util.Collections.reverse(jobs);
        model.addAttribute("jobs", jobs);
        return "candidatehome";
    }

    @GetMapping("/candidateinfo")
    public String showInfo(Model model, HttpSession session) {
        Candidate account = (Candidate) session.getAttribute("user");
        model.addAttribute("candidate", account);
        return "candidateinfo";
    }

    @GetMapping("/addskill")
    public String addJob(Model model, HttpSession session) {
        model.addAttribute("skills", serviceCompany.getAllSkill());
        Candidate account = (Candidate) session.getAttribute("user");
        model.addAttribute("candidate", account);
        return "addskill";
    }

    @PostMapping("/addskill")
    public String postJob(
            @RequestParam List<Long> skillIds,
            HttpSession session
    ) {

        Candidate account = (Candidate) session.getAttribute("user");
        //serviceCompany.createJob(jobName, jobDesc, skillIds, account);
        serviceCandidate.updateSkill(skillIds, account);
        return "redirect:/candidatehome";
    }

    @PostMapping("/updatecandidate")
    public String updateCandidateInfo(
            @RequestParam String fullname,
            @RequestParam String dob,
            @RequestParam String email,
            @RequestParam String phone,
            HttpSession session,
            RedirectAttributes redirectAttributes

    ) {
        Candidate account = (Candidate) session.getAttribute("user");
        if (account != null) {
            account.setFullname(fullname);
            account.setDob(Date.valueOf(dob));
            account.setEmail(email);
            account.setPhone(phone);
            serviceCandidate.updateCandidate(account);
            session.setAttribute("user", account);
            redirectAttributes.addFlashAttribute("updateSuccess", "Candidate information updated successfully!");

        }
        return "redirect:/candidateinfo";
    }

    @GetMapping("/email/{jobId}")
    public String showFormEmailForJob(@PathVariable("jobId") Long jobId, Model model) {
        Optional<Job> jobOptional  = serviceCompany.findById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            model.addAttribute("job", job);
        } else {
            throw new RuntimeException("Job not found for id: " + jobId);
        }

        return "applyforjob";
    }
    @PostMapping("/applyjob")
    public String applyForJob(
            @RequestParam String emailTitle,
            @RequestParam String emailContent,
            @RequestParam Long jobId,
            @RequestParam("attachment") MultipartFile attachment,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) throws MessagingException, IOException {
        Candidate candidate = (Candidate) session.getAttribute("user");
        Job job = serviceCompany.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        String recruiterEmail = job.getCompany().getEmail();
        String candidateEmail = candidate.getEmail();

        String emailBody = "Dear Recruiter " + job.getCompany().getCompName() + " ,\n" +
                emailContent + "\n\n" +
                "Best regards,\n" +
                candidate.getFullname() + "\n" +
                "Email: " + candidateEmail + "\n" +
                "Phone: " + candidate.getPhone();

        emailService.sendEmailWithAttachment(recruiterEmail, emailTitle, emailBody, candidateEmail, attachment);
        redirectAttributes.addFlashAttribute("updateSuccess", "Candidate information updated successfully!");
        job.getAppliedCandidates().add(candidate);
        repoJob.save(job);
        return "redirect:/candidatehome";
    }
    @GetMapping("/detailscandidate/{id}")
    public String jobDetailsCandidate(@PathVariable Long id, Model model, HttpSession session) {
        Job job = serviceCompany.findById2(id);
        Candidate account = (Candidate) session.getAttribute("user");

        List<String> candidateSkill = account.getSkills().stream()
                .map(Skill::getSkillName)
                .collect(Collectors.toList());
        model.addAttribute("candidateSkills", candidateSkill);
        if (job == null) {
            return "redirect:/candidatehome";
        }
        model.addAttribute("job", job);
        return "jobdetailscandidate";
    }
}
