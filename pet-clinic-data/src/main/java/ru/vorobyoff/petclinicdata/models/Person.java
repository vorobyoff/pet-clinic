package ru.vorobyoff.petclinicdata.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static lombok.AccessLevel.PROTECTED;
import static org.springframework.util.StringUtils.capitalize;

@MappedSuperclass
@Getter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class Person extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Person(final String firstName, final String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public void setFirstName(final String firstName) {
        this.firstName = capitalize(firstName);
    }

    public void setLastName(final String lastName) {
        this.lastName = capitalize(lastName);
    }
}