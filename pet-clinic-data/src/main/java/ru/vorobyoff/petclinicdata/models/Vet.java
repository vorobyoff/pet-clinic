package ru.vorobyoff.petclinicdata.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "vet")
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Vet extends Person {

    @ManyToMany(fetch = EAGER)
    @Column(name = "specilities")
    @JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    @Builder
    public Vet(final Long id, final String firstName, final String lastName, final Set<Speciality> specialities) {
        super(id, firstName, lastName);
        this.specialities = specialities;
    }

    public void setSpeciality(final Speciality speciality) {
        speciality.addVet(this);
        specialities.add(speciality);
    }
}