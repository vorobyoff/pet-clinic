package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.jpa.Pet;

public interface PetTypeRepository extends CrudRepository<Pet, Long> {
}