package ru.vorobyoff.petclinicdata.models;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

public class Pet extends BaseEntity {

    private Owner owner;
    private PetType type;
    private LocalDate birthDate;

    public Pet(final Owner owner, final PetType type, final LocalDate birthDate) {
        requireNonNull(owner, "Parameter 'owner' must no be null.");
        this.owner = owner;
        this.type = type;
        this.birthDate = birthDate;
    }

    protected Pet() {
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        requireNonNull(owner, "Parameter 'owner' must not be null.");
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

    public static class PetType extends BaseEntity {

        private String name;

        public PetType(final String name) {
            requireNonNull(name, "Parameter 'name' must not be null.");
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            requireNonNull(name, "Parameter 'name' must not be null.");
            this.name = name;
        }
    }
}