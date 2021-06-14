package ru.vorobyoff.petclinicdata.services;

import ru.vorobyoff.petclinicdata.models.Vet;

import java.util.List;
import java.util.Optional;

public interface VetService {

    Optional<Vet> save(final Vet vet);

    List<Vet> findAll();

    Optional<Vet> findById(final Long id);
}