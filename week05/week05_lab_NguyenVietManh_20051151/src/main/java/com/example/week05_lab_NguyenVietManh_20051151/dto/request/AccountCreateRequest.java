package com.example.week05_lab_NguyenVietManh_20051151.dto.request;

import com.example.week05_lab_NguyenVietManh_20051151.entity.Account;
import com.example.week05_lab_NguyenVietManh_20051151.entity.Address;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateRequest {
    private String username;
    private String password;
    private Date dob;
    private String email;
    private String fullname;
    private String phone;
}
