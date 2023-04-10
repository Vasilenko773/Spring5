package com.example.spring5.jpa.user.dto;

import java.time.LocalDate;

public record PersonalInfo(String firstname, String lastname, LocalDate birthDate) {
}
