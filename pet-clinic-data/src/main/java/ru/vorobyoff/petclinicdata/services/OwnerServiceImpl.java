package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.repositories.OwnerRepository;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public final class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public Owner save(final Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public Collection<Owner> findAll() {
        final var ownersIterator = ownerRepository.findAll().iterator();
        return createStreamFromIterator(ownersIterator).collect(toList());
    }

    @Override
    public Owner findById(final Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Owner with the given id does not exist."));
    }

    @Override
    public List<Owner> findAllByLastName(final String lastName) {
        final var ownersIterator = ownerRepository.findAllByLastNameLike(lastName).iterator();
        return createStreamFromIterator(ownersIterator).collect(toList());
    }

    @Override
    public void delete(final Owner obj) {
        ownerRepository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        ownerRepository.deleteById(id);
    }
}