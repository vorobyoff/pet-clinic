package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.OwnerService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(final Owner obj) {
        return super.save(obj);
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
}