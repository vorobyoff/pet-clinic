package ru.vorobyoff.petclinicdata.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "owner")
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "owner", cascade = ALL)
    private List<Pet> pets = new ArrayList<>();

    public Owner(final Long id, final String firstName, final String lastName, final String address, final String city, final String phone, final List<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.pets = pets;
    }

    @Deprecated
    // Using only for JPA
    protected Owner() {
    }

    public Owner(final String firstName, final String lastName, final String address, final String city, final String phone) {
        super(null, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(final List<Pet> pets) {
        this.pets = pets;
    }

    public Owner tamePet(final Pet pet) {
        pet.setOwner(this);
        pets.add(pet);
        return this;
    }
}