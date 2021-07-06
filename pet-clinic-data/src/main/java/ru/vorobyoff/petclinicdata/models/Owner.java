package ru.vorobyoff.petclinicdata.models;

import lombok.AllArgsConstructor;
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
import static org.springframework.util.StringUtils.capitalize;

@Entity
@Table(name = "owner")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Setter
    @Column(name = "phone")
    private String phone;
    @Setter
    @OneToMany(mappedBy = "owner", cascade = ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner(final String firstName, final String lastName, final String address,
                 final String city, final String phone) {
        super(firstName, lastName);
        setAddress(address);
        setCity(city);
        this.phone = phone;
    }

    public void tamePet(final Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
    }

    public void setAddress(final String address) {
        this.address = capitalize(address);
    }

    public void setCity(final String city) {
        this.city = capitalize(city);
    }
}