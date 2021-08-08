package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.repositories.PetTypeRepository;
import ru.vorobyoff.petclinicdata.services.base.PetTypeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    @Override
    public final PetType save(final PetType obj) {
        return petTypeRepository.save(obj);
    }

    @Override
    public Set<PetType> findAll() {
        final var typesIterator = petTypeRepository.findAll().iterator();
        return createStreamFromIterator(typesIterator).collect(toSet());
    }

    @Override
    public final PetType findById(final Long id) {
        return petTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PetType with the given id does not exist."));
    }

    @Override
    @Transactional
    public List<String> findAllPetTypesDescriptions() {
        return findAll().stream()
                .map(PetType::getName)
                .collect(toList());
    }

    @Override
    public final void delete(final PetType obj) {
        petTypeRepository.delete(obj);
    }

    @Override
    public final void deleteById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}