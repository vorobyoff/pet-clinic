package ru.vorobyoff.petclinicdata.models.map;

public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}