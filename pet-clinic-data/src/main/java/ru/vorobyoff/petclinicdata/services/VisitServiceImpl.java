package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Visit;
import ru.vorobyoff.petclinicdata.repositories.VisitRepository;
import ru.vorobyoff.petclinicdata.services.base.VisitService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository repository;

    public VisitServiceImpl(final VisitRepository repository) {
        this.repository = repository;
    }

    @Override
    public Visit save(final Visit obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<Visit> findAll() {
        final var visits = new ArrayList<Visit>();
        repository.findAll().iterator().forEachRemaining(visits::add);
        return visits;
    }

    @Override
    public Optional<Visit> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Visit obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}