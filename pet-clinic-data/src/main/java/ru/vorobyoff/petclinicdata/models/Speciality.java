package ru.vorobyoff.petclinicdata.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "speciality")
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
    @Column(name = "vets")
    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets;

    @Builder
    public Speciality(final Long id, final String description, final Set<Vet> vets) {
        super(id);
        this.description = description;
        this.vets = vets == null ? new HashSet<>() : vets;
    }

    public void addVet(final Vet vet) {
        vets.add(vet);
    }
}