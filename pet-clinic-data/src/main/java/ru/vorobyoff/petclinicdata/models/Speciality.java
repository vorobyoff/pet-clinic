package ru.vorobyoff.petclinicdata.models;

import lombok.AllArgsConstructor;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
    @Column(name = "vets")
    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

    public void addVet(final Vet vet) {
        vets.add(vet);
    }
}