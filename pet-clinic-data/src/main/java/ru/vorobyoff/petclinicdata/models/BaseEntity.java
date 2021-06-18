package ru.vorobyoff.petclinicdata.models;

import java.io.Serializable;

import static java.util.Objects.requireNonNull;

public class BaseEntity implements Serializable {

    private Long id;

    public BaseEntity(final Long id) {
        requireNonNull(id, "Parameter 'id' must not be null.");
        this.id = id;
    }

    protected BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        requireNonNull(id, "Parameter 'id' must not be null.");
        this.id = id;
    }
}