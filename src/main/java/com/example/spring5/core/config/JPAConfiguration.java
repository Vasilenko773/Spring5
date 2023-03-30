package com.example.spring5.core.config;

import com.example.spring5.core.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Conditional({JpaCondition.class})
@Configuration
public class JPAConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("Jpa configuration is enable");
    }
}
