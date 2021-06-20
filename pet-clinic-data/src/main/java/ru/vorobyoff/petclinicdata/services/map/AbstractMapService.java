package ru.vorobyoff.petclinicdata.services.map;

import ru.vorobyoff.petclinicdata.models.BaseEntity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import static java.util.Collections.max;
import static java.util.Optional.ofNullable;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected final Map<Long, T> storage = new HashMap<>();

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

    public T save(final T obj) {
        if (obj != null && obj.getId() == null) {
            obj.setId(generateNextId());
            return storage.put(obj.getId(), obj);
        } else throw new IllegalArgumentException("Object cannot be null.");
    }

    private Long generateNextId() {
        var next = 1L;
        try {
            next = max(storage.keySet()) + 1;
        } catch (final NoSuchElementException ignored) {
        }

        return next;
    }
}