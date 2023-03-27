package com.example.spring5.core.repository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CrudRepository<Integer, Company> companyRepository;

    public CompanyService(CrudRepository<Integer, Company> companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> findById(Integer id) {
       return companyRepository.findById(id);
    }


    public void delete(Company entity) {
       companyRepository.delete(entity);
    }
}
