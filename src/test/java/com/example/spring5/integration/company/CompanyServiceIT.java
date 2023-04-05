package com.example.spring5.integration.company;

import com.example.spring5.jpa.company.CompanyService;
import com.example.spring5.jpa.company.dto.CompanyReadDto;
import com.example.spring5.integration.annotation.IT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;
    @Autowired
    private CompanyService companyService;

    @Test
    void findById() {
        var actual = companyService.findById(COMPANY_ID);

        assertTrue(actual.isPresent());

        var expected = Optional.of(new CompanyReadDto(COMPANY_ID));
        assertEquals(expected, actual);
    }
}
