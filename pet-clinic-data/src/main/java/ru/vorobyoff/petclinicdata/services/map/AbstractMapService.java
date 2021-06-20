package ru.vorobyoff.petclinicdata.services.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public abstract class AbstractMapService<T, ID> {

    protected final Map<ID, T> storage = new HashMap<>();

    public Collection<T> findAll() {
        return storage.values();
    }

    public Optional<T> findById(final ID id) {
        return ofNullable(storage.get(id));
    }

    public void delete(final T obj) {
        storage.entrySet().removeIf(e -> e.getValue().equals(obj));
    }

    public void deleteById(final ID id) {
        storage.remove(id);
    }
}