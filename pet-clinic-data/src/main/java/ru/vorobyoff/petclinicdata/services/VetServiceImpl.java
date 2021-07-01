package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.repositories.VetRepository;
import ru.vorobyoff.petclinicdata.services.base.VetService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class VetServiceImpl implements VetService {

    private final VetRepository repository;

    public VetServiceImpl(final VetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vet save(final Vet obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<Vet> findAll() {
        final var types = new HashSet<Vet>();
        repository.findAll().iterator()
                .forEachRemaining(types::add);
        return types;
    }

    @Override
    public Optional<Vet> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Vet obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}