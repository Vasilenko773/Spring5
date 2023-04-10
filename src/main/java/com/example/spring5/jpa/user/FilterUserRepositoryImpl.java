package com.example.spring5.jpa.user;

import com.example.spring5.jpa.user.dto.UserFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

   private final EntityManager entityManager;

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
}
