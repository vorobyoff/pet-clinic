package ru.vorobyoff.petclinicdata.models.map;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(final Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public void addSpeciality(final Speciality speciality) {
        specialities.add(speciality);
    }
}