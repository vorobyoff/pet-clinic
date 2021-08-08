package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Speciality;
import ru.vorobyoff.petclinicdata.repositories.SpecialityRepository;
import ru.vorobyoff.petclinicdata.services.base.SpecialityService;

import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public final class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Override
    public Speciality save(final Speciality obj) {
        return specialityRepository.save(obj);
    }

    @Override
    public Set<Speciality> findAll() {
        final var specialityIterator = specialityRepository.findAll().iterator();
        return createStreamFromIterator(specialityIterator).collect(toSet());
    }

    @Override
    public Speciality findById(final Long id) {
        return specialityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Speciality with the given id does not exist."));
    }

    @Override
    public void delete(final Speciality obj) {
        specialityRepository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        specialityRepository.deleteById(id);
    }
}