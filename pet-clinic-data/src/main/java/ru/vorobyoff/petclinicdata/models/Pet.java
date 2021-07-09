package ru.vorobyoff.petclinicdata.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

@Entity
@Table(name = "pet")
@Getter
@Setter
@Builder
@AllArgsConstructor
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
    private Set<Visit> visits = new HashSet<>();
}