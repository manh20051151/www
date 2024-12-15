package com.example.week05_lab_NguyenVietManh_20051151.service;

import com.example.week05_lab_NguyenVietManh_20051151.dto.request.AccountCreateRequest;
import com.example.week05_lab_NguyenVietManh_20051151.dto.request.AccountCreateRequest2;
import com.example.week05_lab_NguyenVietManh_20051151.dto.request.LoginRequest;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Account;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Candidate;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Company;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoAccount;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoCandidate;
import com.example.week05_lab_NguyenVietManh_20051151.repository.RepoCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAccount {
    @Autowired
    private RepoCandidate repoCandidate;

    @Autowired
    private RepoAccount repoAccount;

    @Autowired
    private RepoCompany repoCompany;

    public Account createAccCandidate(AccountCreateRequest request){
        Account account = new Account();
        Candidate candidate = new Candidate();
        candidate.setFullname(request.getFullname());
        candidate.setEmail(request.getEmail());
        candidate.setPhone(request.getPhone());
        candidate.setDob(request.getDob());

        repoCandidate.save(candidate);

        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        account.setCandidate(candidate);

        return repoAccount.save(account);
    }

    public Account createAccCompany(AccountCreateRequest2 request2){
        Account account = new Account();
        Company company = new Company();

        company.setAbout(request2.getAbout());
        company.setCompName(request2.getCompName());
        company.setEmail(request2.getEmail());
        company.setPhone(request2.getPhone());
        company.setWebUrl(request2.getWebUrl());

        repoCompany.save(company);

        account.setUsername(request2.getUsername());
        account.setPassword(request2.getPassword());
        account.setCompany(company);

        return repoAccount.save(account);
    }

//    public boolean login(LoginRequest request){
//        Account account =  repoAccount.findByUsername(request.getUsername());
//        if(account == null){
//            return false;
//        } else if (!account.getPassword().equals(request.getPassword()) ) {
//            return false;
//        }
//        return true;
//    }

    public String login(LoginRequest request){
        Account account =  repoAccount.findByUsername(request.getUsername());
        if(account == null){
            return "false";
        } else if (!account.getPassword().equals(request.getPassword()) ) {
            return "false";
        } else if (account.getCandidate() != null) {
            return "candidate";
        }
        return "company";
    }

    public Account findByUsername(String userName){
        return  repoAccount.findByUsername(userName);
    }

}
