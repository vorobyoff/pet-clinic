package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.models.Owner;

public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> {

    @Override
    public Owner save(final Owner obj) {
        return storage.put(obj.getId(), obj);
    }
}