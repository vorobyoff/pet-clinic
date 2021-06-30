package ru.vorobyoff.petclinicdata.models.map;

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}