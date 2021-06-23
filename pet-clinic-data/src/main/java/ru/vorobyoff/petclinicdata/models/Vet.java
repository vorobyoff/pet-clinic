package ru.vorobyoff.petclinicdata.models;

import java.util.List;

public class Vet extends Person {

    private List<Speciality> specialities;

    public Vet(final String firstName, final String lastName, final List<Speciality> specialities) {
        super(firstName, lastName);
        this.specialities = specialities;
    }

    protected Vet() {
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }
}