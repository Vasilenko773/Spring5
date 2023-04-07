package com.example.spring5;

import com.example.spring5.jpa.company.CompanyRepository;
import jakarta.persistence.NamedQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Spring5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Spring5Application.class, args);
        CompanyRepository bean = run.getBean(CompanyRepository.class);
        bean.findById(1);

    }
}
