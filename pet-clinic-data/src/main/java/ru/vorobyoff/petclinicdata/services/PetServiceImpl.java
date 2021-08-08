package ru.vorobyoff.petclinicdata.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.repositories.PetRepository;
import ru.vorobyoff.petclinicdata.services.base.PetService;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.StreamUtils.createStreamFromIterator;

@Service
@RequiredArgsConstructor
public final class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Override
    public Pet save(final Pet obj) {
        return petRepository.save(obj);
    }

    @Override
    public List<Pet> findAll() {
        final var petIterator = petRepository.findAll().iterator();
        return createStreamFromIterator(petIterator).collect(toList());
    }

    @Override
    public Pet findById(final Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pet with the given id does not exist."));
    }

    @Override
    public void delete(final Pet obj) {
        petRepository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        petRepository.deleteById(id);
    }
}