package com.example.week05_lab_NguyenVietManh_20051151.repository;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAccount extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
