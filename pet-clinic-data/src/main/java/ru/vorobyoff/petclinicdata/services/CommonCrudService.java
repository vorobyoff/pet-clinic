package ru.vorobyoff.petclinicdata.services;

import java.util.Collection;
import java.util.Optional;

public interface CommonCrudService<T, ID> {

    T save(T obj);

    Collection<T> findAll();

    Optional<T> findById(ID id);

    void delete(T obj);

    void deleteById(ID id);
}
