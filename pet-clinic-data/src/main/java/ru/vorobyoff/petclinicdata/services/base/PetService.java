package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.Pet;

import java.util.List;

public interface PetService extends CommonCrudService<Pet, Long> {

    @Override
    List<Pet> findAll();
}