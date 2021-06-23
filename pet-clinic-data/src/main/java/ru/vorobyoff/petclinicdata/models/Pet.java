package ru.vorobyoff.petclinicdata.models;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Pet extends BaseEntity {

    private Owner owner;
    private PetType type;
    private LocalDate birthDate;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public Optional<PetType> getType() {
        return ofNullable(type);
    }

    public void setType(final PetType type) {
        this.type = type;
    }

    public Optional<LocalDate> getBirthDate() {
        return ofNullable(birthDate);
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}