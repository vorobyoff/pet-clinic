package ru.vorobyoff.petclinicdata.models;

import java.util.List;

public class Owner extends Person {

    private List<Pet> pets;

    public Owner(final String firstName, final String lastName, final List<Pet> pets) {
        super(firstName, lastName);
        this.pets = pets;
    }

    protected Owner() {
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}