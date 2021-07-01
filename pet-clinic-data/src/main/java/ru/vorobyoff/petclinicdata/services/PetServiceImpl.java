package ru.vorobyoff.petclinicdata.services;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.repositories.PetRepository;
import ru.vorobyoff.petclinicdata.services.base.PetService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository repository;

    public PetServiceImpl(final PetRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pet save(final Pet obj) {
        return repository.save(obj);
    }

    @Override
    public Collection<Pet> findAll() {
        final var pets = new ArrayList<Pet>();
        repository.findAll().iterator()
                .forEachRemaining(pets::add);
        return pets;
    }

    @Override
    public Optional<Pet> findById(final Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(final Pet obj) {
        repository.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}