package com.example.spring5.core.config;

import com.example.spring5.jpa.company.CompanyRepository;
import com.example.spring5.jpa.company.ConnectionPool;
import com.example.spring5.web.config.WebConfiguration;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration()
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool pool2() {
        return new ConnectionPool("2-url", "secondName", "password");
    }

    @Bean
    @Profile("web")
    public ConnectionPool pool3() {
        return new ConnectionPool("3-url", "thirdName", "password3");
    }

}
