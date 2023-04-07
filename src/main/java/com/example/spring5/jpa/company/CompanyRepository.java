package com.example.spring5.jpa.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c where c.name =:name")
    Optional<Company> findByName(String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);


}
