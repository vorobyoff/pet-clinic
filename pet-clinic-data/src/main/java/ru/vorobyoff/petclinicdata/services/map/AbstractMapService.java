package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.services.CommonCrudService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public abstract class AbstractMapService<T, ID> implements CommonCrudService<T, ID> {

    protected final Map<ID, T> storage = new HashMap<>();

    @Override
    public Collection<T> findAll() {
        return storage.values();
    }

    @Override
    public Optional<T> findById(final ID id) {
        return ofNullable(storage.get(id));
    }

    @Override
    public void delete(final T obj) {
        storage.entrySet().removeIf(e -> e.getValue().equals(obj));
    }

    @Override
    public void deleteById(final ID id) {
        storage.remove(id);
    }
}