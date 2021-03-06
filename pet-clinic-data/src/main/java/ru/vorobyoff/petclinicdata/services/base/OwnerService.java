package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.Owner;

import java.util.List;

public interface OwnerService extends CommonCrudService<Owner, Long> {

    List<Owner> findAllByLastName(final String lastName);
}