package com.example.spring5.jpa.company;

import com.example.spring5.jpa.company.dto.CompanyReadDto;
import com.example.spring5.core.lisner.entity.AccessType;
import com.example.spring5.core.lisner.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id).map(company -> {
            eventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
            return new CompanyReadDto(company.getId());
        });

    }

    public void delete(Company entity) {
        companyRepository.delete(entity);
    }
}
