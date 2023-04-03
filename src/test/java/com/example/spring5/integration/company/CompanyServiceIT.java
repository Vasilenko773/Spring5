package com.example.spring5.integration.company;

import com.example.spring5.core.company.CompanyService;
import com.example.spring5.core.company.dto.CompanyReadDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListener;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
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
