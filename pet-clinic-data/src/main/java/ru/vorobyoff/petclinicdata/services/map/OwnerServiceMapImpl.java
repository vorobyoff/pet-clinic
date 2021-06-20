package ru.vorobyoff.petclinicdata.services.map;

import org.springframework.stereotype.Service;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.OwnerService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class OwnerServiceMapImpl extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner save(final Owner obj) {
        return storage.put(obj.getId(), obj);
    }

    @Override
    public List<Owner> findByLastName(final String lastName) {
        return storage.values().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .collect(toList());
    }
}