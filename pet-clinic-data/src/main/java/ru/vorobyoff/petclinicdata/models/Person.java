package ru.vorobyoff.petclinicdata.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static org.springframework.util.StringUtils.capitalize;

@MappedSuperclass
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Person(final Long id, final String firstName, final String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = capitalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = capitalize(lastName);
    }
}