package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.repositories.VetRepository;
import ru.vorobyoff.petclinicdata.services.base.VetService;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public final class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;

    @Override
    public Vet save(final Vet obj) {
        return vetRepository.save(obj);
    }

    @Override
    public List<Vet> findAll() {
        final var vetIterator = vetRepository.findAll().iterator();
        return createStreamFromIterator(vetIterator).collect(toList());
    }

    @Override
    public Vet findById(final Long id) {
        return vetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vet with the given id does not exist."));
    }

    @Override
    public void delete(final Vet obj) {
        vetRepository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        vetRepository.deleteById(id);
    }
}