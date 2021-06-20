package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.services.VetService;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(final Vet obj) {
        return storage.put(obj.getId(), obj);
    }
}