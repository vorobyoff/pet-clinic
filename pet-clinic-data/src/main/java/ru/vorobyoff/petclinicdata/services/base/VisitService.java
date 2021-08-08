package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.Visit;

import java.util.Set;

public interface VisitService extends CommonCrudService<Visit, Long> {

    @Override
    Set<Visit> findAll();
}
