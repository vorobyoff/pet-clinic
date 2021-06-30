package ru.vorobyoff.petclinicdata.models.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "pet")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "owner")
    @JoinColumn(name = "owner_id")
    @ManyToOne(targetEntity = Owner.class)
    private Owner owner;
    @ManyToOne
    @Column(name = "type")
    @JoinColumn(name = "type_id")
    private PetType type;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @OneToMany(cascade = ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Pet(final Long id, final String name, final Owner owner, final PetType type, final LocalDate birthDate, final Set<Visit> visits) {
        super(id);
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.birthDate = birthDate;
        this.visits = visits;
    }

    protected Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    public PetType getType() {
        return type;
    }

    public void setType(final PetType type) {
        this.type = type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(final Set<Visit> visits) {
        this.visits = visits;
    }
}