package ru.vorobyoff.petclinicdata.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.vorobyoff.petclinicdata.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}