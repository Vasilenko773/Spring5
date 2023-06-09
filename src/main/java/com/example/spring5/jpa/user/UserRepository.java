package com.example.spring5.jpa.user;

import com.example.spring5.jpa.user.dto.PersonalInfo2;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, FilterUserRepository {


    @Query("select u from User  u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Modifying
    @Query("update User u set u.role = :role where u.id in :ids")
    int updateRole(Role role, Integer... ids);


    Optional<User> findFirstByOrderByIdDesc();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints(@QueryHint(name = "org.hibernate,fetchSize", value = "50"))
    List<User> findFirst3ByBirthDateBefore(LocalDate date, Sort sort);

    @EntityGraph(attributePaths = {"company"})
    Page<User> findAllBy(Pageable pageable);

//    List<PersonalInfo> findAllByCompanyId(Integer companyId);

    @Query(value = "SELECT firstName, lastName, birth_date birthDate FROM USERS WHERE company_id = :companyId", nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer companyId);


    Optional<User> findByUsername(String username);
}
