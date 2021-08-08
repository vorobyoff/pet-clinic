package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Visit;
import ru.vorobyoff.petclinicdata.repositories.VisitRepository;
import ru.vorobyoff.petclinicdata.services.base.VisitService;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public final class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Visit save(final Visit obj) {
        return visitRepository.save(obj);
    }

    @Override
    public Set<Visit> findAll() {
        final var visitIterator = visitRepository.findAll().iterator();
        return createStreamFromIterator(visitIterator).collect(toSet());
    }

    @Override
    public Visit findById(final Long id) {
        return visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit with the given id does not exist."));
    }

    @Override
    public void delete(final Visit obj) {
        visitRepository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        visitRepository.deleteById(id);
    }
}