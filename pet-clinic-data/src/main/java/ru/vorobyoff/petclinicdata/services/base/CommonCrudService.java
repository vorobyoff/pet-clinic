package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.BaseEntity;

import java.util.Collection;

public interface CommonCrudService<E extends BaseEntity, I extends Long> {

    E save(final E obj);

    Collection<E> findAll();

    E findById(final I i);

    void delete(final E obj);

    void deleteById(final I i);
}