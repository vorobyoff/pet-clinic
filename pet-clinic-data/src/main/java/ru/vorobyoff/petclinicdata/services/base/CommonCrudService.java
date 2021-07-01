package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface CommonCrudService<T extends BaseEntity, ID extends Long> {

    T save(final T obj);

    Collection<T> findAll();

    Optional<T> findById(final ID id);

    void delete(final T obj);

    void deleteById(final ID id);
}