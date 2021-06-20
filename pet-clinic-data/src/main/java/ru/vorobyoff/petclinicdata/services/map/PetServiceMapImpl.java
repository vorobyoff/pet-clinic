package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.services.PetService;

public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(final Pet obj) {
        return storage.put(obj.getId(), obj);
    }
}