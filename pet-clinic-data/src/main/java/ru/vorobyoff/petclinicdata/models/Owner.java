package ru.vorobyoff.petclinicdata.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "owner")
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "owner", cascade = ALL)
    private List<Pet> pets = new ArrayList<>();

    @Builder
    public Owner(final Long id, final String firstName, final String lastName, final String address,
                 final String city, final String phone, final List<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    public void tamePet(final Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
    }
}