package ru.vorobyoff.petclinicdata.services.map.base;

import ru.vorobyoff.petclinicdata.models.map.Owner;
import ru.vorobyoff.petclinicdata.services.CommonCrudService;

import java.util.List;

public interface OwnerService extends CommonCrudService<Owner, Long> {

    List<Owner> findByLastName(final String lastName);
}