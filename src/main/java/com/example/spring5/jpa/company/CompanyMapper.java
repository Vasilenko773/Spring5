package com.example.spring5.jpa.company;

import com.example.spring5.jpa.company.dto.CompanyReadDto;
import com.example.spring5.web.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements Mapper<Company, CompanyReadDto> {
    @Override
    public CompanyReadDto map(Company object) {
        return new CompanyReadDto(object.getId(), object.getName(), object.getLocales());
    }
}
