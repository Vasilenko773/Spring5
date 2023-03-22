package com.example.spring5.domain.repository;

import java.util.Optional;

public interface CrudRepository<K, E> {

    Optional<E> findById(K id);

    void delete(E entity);
}
