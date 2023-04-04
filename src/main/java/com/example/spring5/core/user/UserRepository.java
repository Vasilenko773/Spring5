package com.example.spring5.core.user;

import com.example.spring5.core.repository.CrudRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Log4j2
public class UserRepository implements CrudRepository<Integer, User> {
    @Override
    public Optional<User> findById(Integer id) {
        return Optional.of(new User(id));
    }

    @Override
    public void delete(User entity) {
        log.info("UserRepository.delete() " + entity);
    }
}
