package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.repositories.OwnerRepository;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

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
    public List<Owner> findAllByLastname(final String lastname) {
        final var ownerIterator = repository.findAllByLastNameLike(lastname).iterator();
        return createStreamFromIterator(ownerIterator).collect(toList());
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
