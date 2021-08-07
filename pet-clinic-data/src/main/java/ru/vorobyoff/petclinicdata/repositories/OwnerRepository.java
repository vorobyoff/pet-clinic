package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Iterable<Owner> findOwnersByLastName(final String lastName);

    @Query("SELECT owner FROM Owner owner WHERE owner.lastName LIKE %?1")
    Iterable<Owner> findAllByLastNameLike(final String lastname);
}