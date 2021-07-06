package ru.vorobyoff.petclinicdata.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
import static lombok.AccessLevel.PROTECTED;
import static org.springframework.util.StringUtils.capitalize;

@Entity
@Table(name = "pet")
@Getter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Setter
    private Owner owner;
    @ManyToOne
    @JoinColumn(name = "type_id")
    @Setter
    private PetType type;
    @Column(name = "birthDate")
    @Setter
    private LocalDate birthDate;
    @OneToMany(cascade = ALL, mappedBy = "pet")
    @Setter
    private Set<Visit> visits = new HashSet<>();

    public Pet(final String name, final PetType type, final LocalDate birthDate) {
        setName(name);
        this.type = type;
        this.birthDate = birthDate;
    }

    public void setName(final String name) {
        this.name = capitalize(name);
    }
}