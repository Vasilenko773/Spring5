package com.example.spring5.domain.repository;

import com.example.spring5.annotation.Auditing;
import com.example.spring5.annotation.InjectBean;
import com.example.spring5.annotation.MyTransaction;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@MyTransaction
@Auditing
@Data
public class CompanyRepository implements CrudRepository<Integer, Company> {

    @Autowired
    private ConnectionPool pool;

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
