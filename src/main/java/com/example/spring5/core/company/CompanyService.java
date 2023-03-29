package com.example.spring5.core.company;

import com.example.spring5.core.company.dto.CompanyReadDto;
import com.example.spring5.core.lisner.entity.AccessType;
import com.example.spring5.core.lisner.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;
    private final ApplicationEventPublisher eventPublisher;



    public Optional<CompanyReadDto> findById(Integer id) {
       return companyRepository.findById(id).map(company -> {
           eventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
           return new CompanyReadDto(company.id());
       });

    }

    public void delete(Company entity) {
       companyRepository.delete(entity);
    }
}
