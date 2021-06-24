package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.services.OwnerService;
import ru.vorobyoff.petclinicdata.services.PetService;
import ru.vorobyoff.petclinicdata.services.PetTypeService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMapImpl(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(final Owner obj) {
        if (obj != null) {
            if (obj.getPets() != null)
                savePets(obj.getPets());

            return super.save(obj);
        } else return null;
    }

    @Override
    public Collection<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public List<Owner> findByLastName(final String lastName) {
        return storage.values().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .collect(toList());
    }

    @Override
    public Optional<Owner> findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(final Owner obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    private void savePets(final List<Pet> pets) {
        pets.forEach(pet -> {
            if (pet.getType() != null) savePetType(pet.getType());
            else throw new IllegalStateException("PetType is required.");
            savePet(pet);
        });
    }

    private void savePetType(final PetType type) {
        if (type.getId() == null) {
            final var saved = petTypeService.save(type);
            type.setId(saved.getId());
        }
    }

    private void savePet(final Pet pet) {
        if (pet.getId() == null) {
            final var saved = petService.save(pet);
            pet.setId(saved.getId());
        }
    }
}