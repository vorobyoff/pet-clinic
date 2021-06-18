package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.models.Pet;

public class PetServiceMapImpl extends AbstractMapService<Pet, Long> {

    @Override
    public Pet save(final Pet obj) {
        return storage.put(obj.getId(), obj);
    }
}