package com.example.spring5.jpa.user;

import com.example.spring5.jpa.user.dto.UserFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

   private final EntityManager entityManager;
   private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        var user = criteria.from(User.class);
        criteria.select(user);
        List<Predicate> predicates = new ArrayList<>();
        if (userFilter.firstname()!= null) {
            predicates.add(criteriaBuilder.like(user.get("firstname"), userFilter.firstname()));
        }
        if (userFilter.lastname()!= null) {
            predicates.add(criteriaBuilder.like(user.get("lastname"), userFilter.lastname()));
        }
        if (userFilter.birthDate()!= null) {
            predicates.add(criteriaBuilder.lessThan(user.get("birthDate"), userFilter.birthDate()));
        }
        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public void updateCompanyAndRole(List<User> users) {
        List<Object[]> params = users.stream()
                .map(u -> new Object[]{u.getCompany().getId(), u.getRole().name(), u.getId()})
                .toList();
        jdbcTemplate.batchUpdate("update users set company_id = ?, role =? where id = ?", params);

    }
}
