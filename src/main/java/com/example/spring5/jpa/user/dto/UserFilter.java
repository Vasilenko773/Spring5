package com.example.spring5.jpa.user.dto;

import java.time.LocalDate;

public record UserFilter(String firstname, String lastname, LocalDate birthDate) {
}
