package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.repositories.OwnerRepository;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository repository;

    public OwnerServiceImpl(final OwnerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Owner save(final Owner obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<Owner> findAll() {
        final var owners = new ArrayList<Owner>();
        repository.findAll().iterator()
                .forEachRemaining(owners::add);
        return owners;
    }

    @Override
    public Optional<Owner> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Owner> findByLastName(final String lastName) {
        final var owners = new ArrayList<Owner>();
        repository.findOwnersByLastName(lastName).iterator()
                .forEachRemaining(owners::add);
        return owners;
    }

    @Override
    public void delete(final Owner obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
