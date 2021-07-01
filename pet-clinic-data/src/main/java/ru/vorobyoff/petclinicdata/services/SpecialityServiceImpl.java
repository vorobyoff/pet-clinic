package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Speciality;
import ru.vorobyoff.petclinicdata.repositories.SpecialityRepository;
import ru.vorobyoff.petclinicdata.services.base.SpecialityService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository repository;

    public SpecialityServiceImpl(final SpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Speciality save(final Speciality obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<Speciality> findAll() {
        final var specs = new HashSet<Speciality>();
        repository.findAll().iterator()
                .forEachRemaining(specs::add);
        return specs;
    }

    @Override
    public Optional<Speciality> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Speciality obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
