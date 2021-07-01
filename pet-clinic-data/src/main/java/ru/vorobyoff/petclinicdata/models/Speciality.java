package ru.vorobyoff.petclinicdata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "speciality")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
    @Column(name = "vets")
    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    public Speciality(final Long id, final String description, final Set<Vet> vets) {
        super(id);
        this.description = description;
        this.vets = vets;
    }

    public Speciality(final String description) {
        super(null);
        this.description = description;
    }

    protected Speciality() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<Vet> getVets() {
        return vets;
    }

    public void setVets(final Set<Vet> vets) {
        this.vets = vets;
    }

    public void addVet(final Vet vet) {
        vets.add(vet);
    }
}