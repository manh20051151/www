package com.example.week06_lab_nguyenvietmanh_20051151.repository;

import com.example.week06_lab_nguyenvietmanh_20051151.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByBalanceGreaterThan(double amount, Pageable pageable);
}
