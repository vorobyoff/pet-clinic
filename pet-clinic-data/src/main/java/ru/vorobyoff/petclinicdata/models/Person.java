package ru.vorobyoff.petclinicdata.models;

import static java.util.Objects.requireNonNull;
import static org.springframework.util.StringUtils.capitalize;

public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    public Person(final String firstName, final String lastName) {
        requireNonNull(firstName, "Parameter 'firstName' must not be null.");
        requireNonNull(firstName, "Parameter 'lastName' must not be null.");
        this.firstName = capitalize(firstName);
        this.lastName = capitalize(lastName);
    }

    protected Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        requireNonNull(firstName, "Parameter 'firstName' must not be null.");
        this.firstName = capitalize(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        requireNonNull(lastName, "Parameter 'lastName' must not be null.");
        this.lastName = capitalize(lastName);
    }
}