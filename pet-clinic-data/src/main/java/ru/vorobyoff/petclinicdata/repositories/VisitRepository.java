package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}