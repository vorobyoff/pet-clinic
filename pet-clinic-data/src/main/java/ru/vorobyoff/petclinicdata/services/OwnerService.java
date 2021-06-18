package ru.vorobyoff.petclinicdata.services;

import ru.vorobyoff.petclinicdata.models.Owner;

import java.util.List;

public interface OwnerService extends CommonCrudService<Owner, Long> {

    List<Owner> findByLastName(final String lastName);
}