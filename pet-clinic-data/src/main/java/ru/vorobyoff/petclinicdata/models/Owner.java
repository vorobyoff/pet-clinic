package ru.vorobyoff.petclinicdata.models;

import java.util.List;

public class Owner extends Person {

    private String address;
    private String city;
    private String phone;
    private List<Pet> pets;

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
}