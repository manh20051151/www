package com.example.week05_lab_NguyenVietManh_20051151.controller;

import com.example.week05_lab_NguyenVietManh_20051151.dto.request.AccountCreateRequest;
import com.example.week05_lab_NguyenVietManh_20051151.dto.request.AccountCreateRequest2;
import com.example.week05_lab_NguyenVietManh_20051151.dto.request.LoginRequest;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Account;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Candidate;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Company;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceAccount;
import com.example.week05_lab_NguyenVietManh_20051151.service.ServiceCompany;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContrAccount {
    @Autowired
    private ServiceAccount serviceAccount;
    @Autowired
    private ServiceCompany serviceCompany;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("accountCreateRequest", new AccountCreateRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute AccountCreateRequest request, RedirectAttributes redirectAttributes) {

        Account createdAccount = serviceAccount.createAccCandidate(request);
        redirectAttributes.addFlashAttribute("updateSuccess", "Candidate information updated successfully!");
        return "redirect:/login";
    }

    @GetMapping("/registerCompany")
    public String showRegistrationFormCompany(Model model) {
        model.addAttribute("accountCreateRequest2", new AccountCreateRequest2());
        return "registerCompany";
    }

    @PostMapping("/registerCompany")
    public String registerAccountCompany(@ModelAttribute AccountCreateRequest2 request,RedirectAttributes redirectAttributes) {
        Account createdAccount = serviceAccount.createAccCompany(request);
        redirectAttributes.addFlashAttribute("updateSuccess", "Candidate information updated successfully!");
        return "redirect:/login";
    }


    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest request,Model model, HttpSession session){
        if(serviceAccount.login(request).equals("company")){
            Account account = serviceAccount.findByUsername(request.getUsername());
            Company company = account.getCompany();
            session.setAttribute("user", company);
            return "redirect:/companyhome";
        } else if (serviceAccount.login(request).equals("candidate")) {
            Account account = serviceAccount.findByUsername(request.getUsername());
            Candidate candidate = account.getCandidate();
            session.setAttribute("user", candidate);
            return "redirect:/candidatehomeall";
        } else {
            model.addAttribute("err", "Incorrect account or password");
            return "login";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
