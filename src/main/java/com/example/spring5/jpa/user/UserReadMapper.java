package com.example.spring5.jpa.user;

import com.example.spring5.jpa.company.CompanyMapper;
import com.example.spring5.jpa.company.dto.CompanyReadDto;
import com.example.spring5.jpa.user.dto.UserReadDto;
import com.example.spring5.web.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyMapper companyMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto company = Optional.ofNullable(object.getCompany())
                .map(companyMapper::map).orElse(new CompanyReadDto(0, "", Map.of()));

        return new UserReadDto(object.getId(), object.getUsername(),
                object.getBirthDate(), object.getFirstname(), object.getLastname(),
                object.getRole().name(), company);
    }
}
