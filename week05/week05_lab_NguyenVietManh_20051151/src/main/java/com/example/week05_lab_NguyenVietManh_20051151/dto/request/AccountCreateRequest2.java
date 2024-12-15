package com.example.week05_lab_NguyenVietManh_20051151.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateRequest2 {
    private String username;
    private String password;
    private String about;
    private String compName;
    private String email;
    private String phone;
    private String webUrl;
}
