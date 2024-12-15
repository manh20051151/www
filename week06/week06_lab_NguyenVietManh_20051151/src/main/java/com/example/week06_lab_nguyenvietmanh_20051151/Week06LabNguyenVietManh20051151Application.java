package com.example.week06_lab_nguyenvietmanh_20051151;

import com.example.week06_lab_nguyenvietmanh_20051151.entity.Account;
import com.example.week06_lab_nguyenvietmanh_20051151.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Week06LabNguyenVietManh20051151Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Week06LabNguyenVietManh20051151Application.class, args);
	}

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
//		Random random = new Random();
//		for (long i = 0; i < 10; i++) {
//			Account account = new Account( i , "name # " + i, random.nextDouble(1000d));
//			accountRepository.save(account);
//		}
//		accountRepository.findAll().forEach(System.out::println);

		PageRequest request = PageRequest.of(0, 5);
//		Page<Account> content =  accountRepository.findAll(request);
//		List<Account> accounts = content.getContent();
//		accounts.forEach(System.out::println);

		 accountRepository.findByBalanceGreaterThan(350, request).forEach(System.out::println);
	}
}
