package com.example.spring5.jpa.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select u from User  u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Modifying
    @Query("update User u set u.role = :role where u.id in :ids")
    int updateRole(Role role, Integer... ids);


    Optional<User> findFirstByOrderByIdDesc();

    List<User> findFirst3ByBirthDateBefore(LocalDate date, Sort sort);

    @EntityGraph(attributePaths = {"company"})
    Page<User> findAllBy(Pageable pageable);
}
