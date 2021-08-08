package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.Speciality;

import java.util.Set;

public interface SpecialityService extends CommonCrudService<Speciality, Long> {

    @Override
    Set<Speciality> findAll();
}