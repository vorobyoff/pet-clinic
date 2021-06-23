package ru.vorobyoff.petclinicdata.models;

import java.time.LocalDateTime;

public class Visit extends BaseEntity {

    private LocalDateTime date;
    private String description;
    private Pet pet;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(final Pet pet) {
        this.pet = pet;
    }
}