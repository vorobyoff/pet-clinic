package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.map.Pet;
import ru.vorobyoff.petclinicdata.services.map.base.AbstractMapService;
import ru.vorobyoff.petclinicdata.services.map.base.PetService;

import java.util.Collection;
import java.util.Optional;

@Service
public class PetServiceMapImpl extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Collection<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Pet> findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(final Pet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet save(final Pet obj) {
        return super.save(obj);
    }
}