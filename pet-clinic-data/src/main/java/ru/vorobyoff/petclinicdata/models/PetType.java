package ru.vorobyoff.petclinicdata.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "pet_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;
}