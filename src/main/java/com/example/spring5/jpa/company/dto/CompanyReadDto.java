package com.example.spring5.jpa.company.dto;

import java.util.Map;


public record CompanyReadDto(int id, String name, Map<String, String> locales) {
}
