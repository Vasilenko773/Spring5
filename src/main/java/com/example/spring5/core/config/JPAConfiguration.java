package com.example.spring5.core.config;

import com.example.spring5.core.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional({JpaCondition.class})
@Configuration
@Slf4j
public class JPAConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "db")
//    public DatabaseProperties databaseProperties() {
//        return new DatabaseProperties();
//    }
    @PostConstruct
    public void init() {
        log.info("");
        log.info("#########");
        log.info("com.example.spring5.core.config.JPAConfiguration init()");
        log.info("#########");
        log.info("");
    }
}
