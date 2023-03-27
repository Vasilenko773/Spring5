package com.example.spring5.core.repository;

import com.example.spring5.core.annotation.MyTransaction;
import com.example.spring5.core.annotation.Auditing;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Repository
@MyTransaction
@Auditing
@RequiredArgsConstructor
@Data
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool pool;

    @PostConstruct
    private void init() {
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method()");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete");

    }
}
