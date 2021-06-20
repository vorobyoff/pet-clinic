package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.services.VetService;

import java.util.Collection;
import java.util.Optional;

@Service
public class VetServiceMapImpl extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Collection<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Vet> findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(final Vet obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(final Vet obj) {
        return super.save(obj);
    }
}