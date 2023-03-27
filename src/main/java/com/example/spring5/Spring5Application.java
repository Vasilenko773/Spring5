package com.example.spring5;

import com.example.spring5.config.ApplicationConfiguration;
import com.example.spring5.domain.repository.CompanyService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication

public class Spring5Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
            var companyService = context.getBean("companyService", CompanyService.class);
            System.out.println(companyService.findById(2));
        }
    }
