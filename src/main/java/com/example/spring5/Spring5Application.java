package com.example.spring5;

import com.example.spring5.core.config.ApplicationConfiguration;
import com.example.spring5.core.company.CompanyService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Spring5Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext();

        context.register(ApplicationConfiguration.class);
        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();
        var companyService = context.getBean("companyService", CompanyService.class);
        System.out.println(companyService.findById(2));

    }
}
