package com.example.spring5.jpa.user;

import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {

    Optional<User> findById(Integer id);

   void delete(User entity);
}
