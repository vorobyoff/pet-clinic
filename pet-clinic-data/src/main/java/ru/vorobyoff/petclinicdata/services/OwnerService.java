package ru.vorobyoff.petclinicdata.services;

import ru.vorobyoff.petclinicdata.models.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Optional<Owner> save(Owner owner);

    List<Owner> findAll();

    Optional<Owner> findById(final Long id);

    List<Owner> findByLastName(final String lastName);
}