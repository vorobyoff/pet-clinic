package ru.vorobyoff.petclinicdata.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static lombok.AccessLevel.PROTECTED;
import static org.springframework.util.StringUtils.capitalize;

@Entity
@Table(name = "pet_type")
@Getter
@AllArgsConstructor
@NoArgsConstructor(onConstructor_ = @Deprecated, access = PROTECTED)
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;

    public void setName(final String name) {
        this.name = capitalize(name);
    }
}