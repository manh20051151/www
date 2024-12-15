package com.example.week05_lab_NguyenVietManh_20051151.controller;

import com.example.week05_lab_NguyenVietManh_20051151.dto.request.AccountCreateRequest;
import com.example.week05_lab_NguyenVietManh_20051151.entity.*;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoJob;
import com.example.week05_lab_NguyenVietManh_20051151.service.EmailService;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceCandidate;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceCompany;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.hibernate.engine.internal.Collections;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ContrCompany {

    @Autowired
    private ServiceCompany serviceCompany;

    @Autowired
    private ServiceCandidate serviceCandidate;
    @Autowired
    private EmailService emailService;

    @Autowired
    private RepoJob repoJob;

    @GetMapping("/companyhome")
    public String showListJob(Model model, HttpSession session) {
        Company account = (Company) session.getAttribute("user");

        List<Job> jobs = serviceCompany.findByCompany(account);
        java.util.Collections.reverse(jobs);
        model.addAttribute("jobs", jobs);

//        model.addAttribute("jobs", serviceCompany.findByCompany(account));
        return "companyHome";
    }

    @GetMapping("/companyinfo")
    public String showInfo(Model model, HttpSession session) {
        Company account = (Company) session.getAttribute("user");
        model.addAttribute("company", account);
        return "companyinfo";
    }

    @GetMapping("/companyhomealljob")
    public String showListJobAll(Model model, HttpSession session) {
        Company account = (Company) session.getAttribute("user");

        List<Job> jobs = serviceCompany.getAllJob();
        java.util.Collections.reverse(jobs);
        model.addAttribute("jobs", jobs);


        return "companyHome";
    }

    @GetMapping("/addjob")
    public String addJob(Model model) {
        System.out.println("job:::: " + serviceCompany.getAllSkill());
        model.addAttribute("skills", serviceCompany.getAllSkill());
        return "addjob";
    }

    @PostMapping("/addjob")
    public String postJob(
            @RequestParam String jobName,
            @RequestParam String jobDesc,
            @RequestParam List<Long> skillIds,
            HttpSession session
    ) {

        Company account = (Company) session.getAttribute("user");
        serviceCompany.createJob(jobName, jobDesc, skillIds, account);
        return "redirect:/companyhome";
    }

    //    @GetMapping("/candidate")
//    public String listCandidate(Model model, HttpSession session) {
//        Company account = (Company) session.getAttribute("user");
//        List<Job> jobs = serviceCompany.findByCompany(account);
//
//
//
//        return "candidate";
//    }
    @GetMapping("/candidates/{jobId}")
    public String showCandidatesForJob(@PathVariable("jobId") Long jobId, Model model) {
        Optional<Job> jobOptional = serviceCompany.findById(jobId);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            model.addAttribute("job", job);
            List<Skill> jobSkills = job.getSkills();
            List<String> skillList = job.getSkills().stream()
                    .map(Skill::getSkillName)
                    .collect(Collectors.toList());
            List<Candidate> candidates = serviceCompany.findCandidatesBySkills(jobSkills);
            // Thêm thông tin vào Model
            model.addAttribute("skilllist", skillList);
            model.addAttribute("candidates", candidates);
            model.addAttribute("job", job);
        } else {
            // Xử lý khi job không tồn tại
            throw new RuntimeException("Job not found for id: " + jobId);
        }

        return "candidatelist";
    }

    @PostMapping("/updatecompany")
    public String updateCompany(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String address,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Company account = (Company) session.getAttribute("user");

        if (account != null) {

            account.setCompName(name);
            account.setAbout(description);
            account.setEmail(address);

            serviceCompany.updateCompany(account);
            redirectAttributes.addFlashAttribute("updateSuccess", "Company information updated successfully!");

        }

        return "redirect:/companyinfo";
    }

    @GetMapping("/emailcompany/{candidateId}/{jobId}")
    public String showFormEmail(@PathVariable("candidateId") Long candidateId, @PathVariable("jobId") Long jobId, Model model) {
        Optional<Candidate> jobOptional = serviceCandidate.findById(candidateId);
        if (jobOptional.isPresent()) {
            Candidate candidate = jobOptional.get();
            model.addAttribute("candidate", candidate);
            model.addAttribute("jobId", jobId);
        } else {

            throw new RuntimeException("Job not found for id: " + candidateId);
        }
        return "sendmailcompany";
    }

    @PostMapping("/sendmail")
    public String sendMailCompany(
            @RequestParam String emailTitle,
            @RequestParam String emailContent,
            @RequestParam Long candidateId,
            @RequestParam Long jobId,
            @RequestParam("attachment") MultipartFile attachment,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) throws MessagingException, IOException {
        Company company = (Company) session.getAttribute("user");
        Candidate candidate = serviceCandidate.findById(candidateId).orElseThrow(() -> new RuntimeException("candidateId not found"));
        Job job = serviceCompany.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));

        String candidateEmail = candidate.getEmail();
        String recruiterEmail = company.getEmail();

        String emailBody = "Dear Candidate " + candidate.getFullname() + " ,\n" +
                emailContent + "\n\n" +
                "Best regards,\n" +
                company.getCompName() + "\n" +
                "Email: " + recruiterEmail + "\n" +
                "Phone: " + company.getPhone();

        emailService.sendEmaiCompany(recruiterEmail, emailTitle, emailBody, candidateEmail, attachment);
        redirectAttributes.addFlashAttribute("updateSuccess", "Candidate information updated successfully!");
        job.getAppliedCandidates().add(candidate);
        repoJob.save(job);
        return "redirect:/candidates/" + jobId;
    }

    @GetMapping("/details/{id}")
    public String jobDetails(@PathVariable Long id, Model model) {
        Job job = serviceCompany.findById2(id);
        if (job == null) {
            return "redirect:/companyhome";
        }
        model.addAttribute("job", job);
        return "jobdetails";
    }


    @GetMapping("/editjob/{jobId}")
    public String editJob(@PathVariable("jobId") Long jobId, Model model) {
        Job job = serviceCompany.findById2(jobId);
        model.addAttribute("job", job);
        model.addAttribute("skills", serviceCompany.getAllSkill());
        return "editjob";
    }

    // Phương thức POST để cập nhật công việc
    @PostMapping("/updatejob/{jobId}")
    public String updateJob(
            @PathVariable("jobId") Long jobId,
            @RequestParam String jobName,
            @RequestParam String jobDesc,
            @RequestParam List<Long> skillIds,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Company account = (Company) session.getAttribute("user");
        serviceCompany.updateJob(jobId, jobName, jobDesc, skillIds, account);
        redirectAttributes.addFlashAttribute("updatePostSuccess", "Candidate information updated successfully!");
        return "redirect:/details/" + jobId;
    }

    @GetMapping("/deletejob/{jobId}")
    public String deleteJob(@PathVariable("jobId") Long jobId, RedirectAttributes redirectAttributes) {
        serviceCompany.deleteById(jobId);
        redirectAttributes.addFlashAttribute("deleteSuccess", "Job deleted successfully");
        return "redirect:/companyhome";
    }
}