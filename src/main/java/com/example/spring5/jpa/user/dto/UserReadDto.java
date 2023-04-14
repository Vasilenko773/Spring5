package com.example.spring5.jpa.user.dto;

import com.example.spring5.jpa.company.dto.CompanyReadDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadDto {

    private Integer id;
    private String username;
    private LocalDate birthDate;
    private String firstname;
    private String lastname;
    private String role;
    private CompanyReadDto company;
}
