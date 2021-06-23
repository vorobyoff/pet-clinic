package ru.vorobyoff.petclinicdata.models;

import java.util.List;

public class Vet extends Person {

    private List<Speciality> specialities;

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final List<Speciality> specialities) {
        this.specialities = specialities;
    }
}