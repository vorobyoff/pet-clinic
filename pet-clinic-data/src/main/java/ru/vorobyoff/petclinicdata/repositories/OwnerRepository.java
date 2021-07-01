package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Iterable<Owner> findOwnersByLastName(final String lastName);
}