package ru.vorobyoff.petclinicdata.models;

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
import static org.springframework.util.StringUtils.capitalize;

@Entity
@Table(name = "speciality")
@Getter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;
    @Column(name = "vets")
    @ManyToMany(mappedBy = "specialities")
    @Setter
    private Set<Vet> vets = new HashSet<>();

    public Speciality(final String description) {
        setDescription(description);
    }

    public void addVet(final Vet vet) {
        vets.add(vet);
    }

    public void setDescription(final String description) {
        this.description = capitalize(description);
    }
}