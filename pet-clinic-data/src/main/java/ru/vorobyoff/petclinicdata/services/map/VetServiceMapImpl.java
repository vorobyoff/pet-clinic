package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.models.Vet;

public class VetServiceMapImpl extends AbstractMapService<Vet, Long> {

    @Override
    public Vet save(final Vet obj) {
        return storage.put(obj.getId(), obj);
    }
}