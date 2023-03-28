package com.example.spring5.core.config;

import com.example.spring5.core.repository.ConnectionPool;
import com.example.spring5.core.repository.CrudRepository;
import com.example.spring5.web.config.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration
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
    public ConnectionPool pool2() {
        return new ConnectionPool("test-url", "secondName", "password");
    }

}
