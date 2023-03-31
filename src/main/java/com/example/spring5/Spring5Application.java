package com.example.spring5;

import com.example.spring5.core.company.ConnectionPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Spring5Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Spring5Application.class, args);
        System.out.println(run.getBean("pool2", ConnectionPool.class));
        System.out.println(run.getBean("connectionPool", ConnectionPool.class));

    }
}
