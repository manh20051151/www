package com.example.week05_lab_NguyenVietManh_20051151;

import com.example.week05_lab_NguyenVietManh_20051151.model.Address;
import com.example.week05_lab_NguyenVietManh_20051151.model.Candidate;
import com.example.week05_lab_NguyenVietManh_20051151.repository.AddressRepository;
import com.example.week05_lab_NguyenVietManh_20051151.repository.CandidateRepository;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Week05LabNguyenVietManh20051151Application {

	public static void main(String[] args) {
		SpringApplication.run(Week05LabNguyenVietManh20051151Application.class, args);
	}
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Bean
	CommandLineRunner initData() {
		return args -> {
			Random rnd = new Random();
			for (int i = 1; i < 1000; i++) {
				Address add = new Address();
				add.setStreet("Quang Trung");
				add.setCity("HCM");
				add.setZipcode(rnd.nextInt(70000, 80000) + "");
				add.setCountry(CountryCode.VN);
				add.setNumber("99999");

				// Lưu địa chỉ và kiểm tra
				Address savedAddress = addressRepository.save(add);
				System.out.println("Saved Address: " + savedAddress);

				// Tạo Candidate với Address hợp lệ
				Candidate can = new Candidate(
						0,
						Date.valueOf(LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29))),
						"email_" + i + "@gmail.com",
						"Name #" + i,
						rnd.nextLong(1111111111L, 9999999999L) + "",
						savedAddress
				);

				// Lưu candidate và kiểm tra
				candidateRepository.save(can);
				System.out.println("Added Candidate: " + can);
			}
		};
	}

}
