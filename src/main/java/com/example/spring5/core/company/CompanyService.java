package com.example.spring5.core.company;

import com.example.spring5.core.company.dto.CompanyReadDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;

    public CompanyService(CrudRepository<Integer, Company> companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id) {
       return companyRepository.findById(id).map(company -> new CompanyReadDto(company.id()));
    }

    public void delete(Company entity) {
       companyRepository.delete(entity);
    }
}
