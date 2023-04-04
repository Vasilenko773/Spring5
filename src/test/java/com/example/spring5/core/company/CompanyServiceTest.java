package com.example.spring5.core.company;

import com.example.spring5.core.company.dto.CompanyReadDto;
import com.example.spring5.core.lisner.entity.EntityEvent;
import com.example.spring5.core.repository.CrudRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    private static final Integer COMPANY_ID = 1;

    @Mock
    private CrudRepository<Integer, Company> companyRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        Mockito.doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(companyRepository).findById(COMPANY_ID);

        Optional<CompanyReadDto> byId = companyService.findById(COMPANY_ID);
        var expected = Optional.of(new CompanyReadDto(COMPANY_ID));

        assertTrue(byId.isPresent());
        byId.ifPresent(actual -> assertEquals(expected, byId));
        Mockito.verify(eventPublisher).publishEvent(any(EntityEvent.class));
    }
}