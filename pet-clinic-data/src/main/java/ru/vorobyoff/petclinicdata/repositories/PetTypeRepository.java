package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}