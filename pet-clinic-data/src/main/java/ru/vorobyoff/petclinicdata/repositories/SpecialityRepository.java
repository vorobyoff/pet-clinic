package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}