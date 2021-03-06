package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}