package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.PetType;

import java.util.List;
import java.util.Set;

public interface PetTypeService extends CommonCrudService<PetType, Long> {

    List<String> findAllPetTypesDescriptions();

    @Override
    Set<PetType> findAll();
}