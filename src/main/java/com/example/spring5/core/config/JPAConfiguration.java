package com.example.spring5.core.config;

import com.example.spring5.core.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional({JpaCondition.class})
@Configuration
public class JPAConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return new DatabaseProperties();
//    }
    @PostConstruct
    public void init() {
        System.out.println("");
        System.out.println("#########");
        System.out.println("com.example.spring5.core.config.JPAConfiguration init()");
        System.out.println("#########");
        System.out.println("");
    }
}
