package com.example.spring5.integration.company;

import com.example.spring5.jpa.company.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void test() {
        companyRepository.findByName("google");
        companyRepository.findAllByNameContainingIgnoreCase("a");

    }
}
