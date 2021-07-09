package ru.vorobyoff.petclinicdata.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static lombok.AccessLevel.PROTECTED;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
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
}