package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.services.PetTypeService;

import java.util.Collection;
import java.util.Optional;

@Service
public class PetTypeServiceMapImpl extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Collection<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<PetType> findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(final PetType obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(final PetType obj) {
        return super.save(obj);
    }
}