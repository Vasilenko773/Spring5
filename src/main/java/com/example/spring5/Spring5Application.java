package com.example.spring5;

import com.example.spring5.domain.repository.CrudRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring5Application {

    public static void main(String[] args) {

        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1).orElse("Empty"));
        }
    }
}