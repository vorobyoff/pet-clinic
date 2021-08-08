package ru.vorobyoff.petclinicdata.services.base;

import ru.vorobyoff.petclinicdata.models.Vet;

import java.util.List;

public interface VetService extends CommonCrudService<Vet, Long> {

    @Override
    List<Vet> findAll();
}