package com.example.spring5;

import com.example.spring5.jpa.company.CompanyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Spring5Application.class, args);
        System.out.println();
    }
}
