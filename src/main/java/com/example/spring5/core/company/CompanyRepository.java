package com.example.spring5.core.company;

import com.example.spring5.core.annotation.MyTransaction;
import com.example.spring5.core.annotation.Auditing;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Scope(BeanDefinition.SCOPE_SINGLETON)
@Repository
@MyTransaction
@Auditing
@Data
@RequiredArgsConstructor
@Slf4j
public class CompanyRepository implements CrudRepository<Integer, Company> {

    private final ConnectionPool connectionPool;

    @PostConstruct
    private void init() {
    }

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("findById method()");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        log.info("delete");
    }
}
