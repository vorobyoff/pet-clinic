package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.repositories.PetTypeRepository;
import ru.vorobyoff.petclinicdata.services.base.PetTypeService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository repository;

    public PetTypeServiceImpl(final PetTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public PetType save(final PetType obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<PetType> findAll() {
        final var types = new HashSet<PetType>();
        repository.findAll().iterator()
                .forEachRemaining(types::add);
        return types;
    }

    @Override
    public Optional<PetType> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final PetType obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}