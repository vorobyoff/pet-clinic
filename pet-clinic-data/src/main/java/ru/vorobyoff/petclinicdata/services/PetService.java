package ru.vorobyoff.petclinicdata.services;

import ru.vorobyoff.petclinicdata.models.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    Optional<Pet> save(final Pet pet);

    List<Pet> findAll();

    Optional<Pet> findById(final Long id);
}