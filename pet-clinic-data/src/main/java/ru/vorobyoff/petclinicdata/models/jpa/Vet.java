package ru.vorobyoff.petclinicdata.models.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "vet")
public class Vet extends Person {

    @ManyToMany(fetch = EAGER)
    @Column(name = "specilities")
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specility_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Vet(final Long id, final String firstName, final String lastName, final Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    protected Vet() {
    }

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