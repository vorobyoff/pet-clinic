package ru.vorobyoff.petclinicdata.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "pet")
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @OneToMany(cascade = ALL, mappedBy = "pet")
    private Set<Visit> visits;

    @Builder
    public Pet(final Long id, final String name, final Owner owner, final PetType type, final LocalDate birthDate, final Set<Visit> visits) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.birthDate = birthDate;
        this.visits = visits == null ? new HashSet<>() : visits;
    }

    public void addVisit(final Visit visit) {
        visits.add(requireNonNull(visit));
        visit.setPet(this);
    }
}