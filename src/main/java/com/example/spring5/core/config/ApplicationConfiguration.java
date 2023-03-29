package com.example.spring5.core.config;

import com.example.spring5.core.company.CompanyRepository;
import com.example.spring5.core.company.ConnectionPool;
import com.example.spring5.core.company.CrudRepository;
import com.example.spring5.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration()
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.spring5",
useDefaultFilters = false,
includeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = Component.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
        @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
})
public class ApplicationConfiguration {


    @Bean
    @Profile("prod")
    public ConnectionPool pool2() {
        return new ConnectionPool("2-url", "secondName", "password");
    }

    @Bean
    @Profile("web")
    public ConnectionPool pool3() {
        return new ConnectionPool("3-url", "thirdName", "password3");
    }

    @Bean
    @Profile("web")
    public CompanyRepository company2() {
        ConnectionPool connectionPool = pool3();
        ConnectionPool connectionPool1 = pool3();
        ConnectionPool connectionPool2 = pool3();
        return new CompanyRepository(pool3());
    }

}
