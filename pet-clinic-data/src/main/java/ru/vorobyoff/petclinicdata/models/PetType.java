package ru.vorobyoff.petclinicdata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    public PetType(final Long id, final String name) {
        super(id);
        this.name = name;
    }

    public PetType(final String name) {
        super(null);
        this.name = name;
    }

    protected PetType() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}