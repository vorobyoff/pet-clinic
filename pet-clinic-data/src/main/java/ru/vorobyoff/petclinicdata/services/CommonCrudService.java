package ru.vorobyoff.petclinicdata.services;

import java.util.Collection;
import java.util.Optional;

public interface CommonCrudService<T, ID> {

    T save(final T obj);

    Collection<T> findAll();

    Optional<T> findById(final ID id);

    void delete(final T obj);

    void deleteById(final ID id);
}