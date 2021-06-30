package ru.vorobyoff.petclinicdata.models.map;

import static org.springframework.util.StringUtils.capitalize;

public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

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