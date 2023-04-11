package com.example.spring5.core.config;

import com.example.spring5.Spring5Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
@EnableEnversRepositories(basePackageClasses = Spring5Application.class)
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        //SecurityContext.getcurrentUser().getId
        return () -> Optional.of("dmdev");
    }

}
