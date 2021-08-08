package ru.vorobyoff.petclinicdata.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;
import static java.util.Objects.requireNonNull;
import static javax.persistence.CascadeType.ALL;
import static lombok.AccessLevel.PROTECTED;
import static ru.vorobyoff.petclinicdata.models.Owner.PetsIncluding.EXCLUDE_NEW_PETS;

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
    private Set<Pet> pets;

    @Builder
    public Owner(final Long id, final String firstName, final String lastName, final String address,
                 final String city, final String phone, final Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets == null ? new TreeSet<>(comparing(Pet::getName)) : pets;
    }

    public void tamePet(final Pet pet) {
        requireNonNull(pet).setOwner(this);
        pets.add(pet);
    }

    public Optional<Pet> findPetByName(final String petName) {
        return findPetByName(petName, EXCLUDE_NEW_PETS);
    }

    public Optional<Pet> findPetByName(final String petName, final PetsIncluding includeNewPets) {
        return findPetByNameHelper(requireNonNull(petName), includeNewPets);
    }

    private Optional<Pet> findPetByNameHelper(final String petName, final PetsIncluding doIncludingNewPets) {
        return pets.stream().filter(pet -> !doIncludingNewPets.doIncludingNewPets && !pet.isNew()
                        && petName.equalsIgnoreCase(pet.getName()))
                .findFirst();
    }

    @RequiredArgsConstructor
    public enum PetsIncluding {

        INCLUDE_NEW_PETS(true), EXCLUDE_NEW_PETS(false);

        private final boolean doIncludingNewPets;
    }
}